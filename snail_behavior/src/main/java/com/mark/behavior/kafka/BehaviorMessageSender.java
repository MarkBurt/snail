package com.mark.behavior.kafka;

import com.mark.common.kafka.KafkaMessage;
import com.mark.common.kafka.KafkaSender;
import com.mark.common.kafka.messages.UpdateArticleMessage;
import com.mark.common.kafka.messages.behavior.UserLikesMessage;
import com.mark.common.kafka.messages.behavior.UserReadMessage;
import com.mark.model.behavior.pojos.ApLikesBehavior;
import com.mark.model.mess.app.UpdateArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description :  kfka 发送消息
 * @Author :  Markburt
 * @CreateDate :  2020/2/21$ 下午 10:55$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/21$ 下午 10:55$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Component
@SuppressWarnings("all")
public class BehaviorMessageSender {

    @Autowired
    private KafkaSender kafkaSender;


    /**
     * 发送+1的消息
     *
     * @param message
     * @param apUserId
     * @param isSendToArticle
     */
    public void sendMessagePlus(KafkaMessage message, Long apUserId, boolean isSendToArticle) {
        if(isSendToArticle){
            UpdateArticleMessage temp = parseMessage(message, apUserId, 1);
            kafkaSender.sendArticleUpdateBus(temp);
        }
    }

    /**
     * 发送-1的消息
     *
     * @param message
     * @param apUserId
     * @param isSendToArticle
     */
    public void sendMessageReduce(KafkaMessage message, Long apUserId, boolean isSendToArticle) {
        if(isSendToArticle){
            UpdateArticleMessage temp = parseMessage(message, apUserId, -1);
            kafkaSender.sendArticleUpdateBus(temp);
        }
    }

    private UpdateArticleMessage parseMessage(KafkaMessage message, Long apUserId, int step) {
        UpdateArticle ua = new UpdateArticle();
        if(apUserId!=null){
            ua.setApUserId(apUserId.intValue());
        }
        if(message instanceof UserLikesMessage){
            UserLikesMessage likesMessage = (UserLikesMessage) message;
            //只处理文章数据的点赞
            if(likesMessage.getData().getType() == ApLikesBehavior.Type.ARTICLE.getCode()){
                ua.setType(UpdateArticle.UpdateArticleType.LIKES);
                ua.setAdd(step);
                ua.setArticleId(likesMessage.getData().getEntryId());
                ua.setBehaviorId(likesMessage.getData().getBehaviorEntryId());
            }

        }else if(message instanceof UserReadMessage){
            UserReadMessage userReadMessage = (UserReadMessage) message;
            ua.setType(UpdateArticle.UpdateArticleType.VIEWS);
            ua.setAdd(step);
            ua.setArticleId(userReadMessage.getData().getArticleId());
            ua.setBehaviorId(userReadMessage.getData().getEntryId());
        }

        if(ua.getArticleId()!=null){
            return new UpdateArticleMessage(ua);
        }
        return null;

    }
}
