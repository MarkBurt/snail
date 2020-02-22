package com.mark.behavior.service.impl;

import com.mark.behavior.kafka.BehaviorMessageSender;
import com.mark.behavior.service.AppLikesBehaviorService;
import com.mark.common.kafka.messages.behavior.UserLikesMessage;
import com.mark.common.zookeeper.sequence.Sequences;
import com.mark.model.behavior.dtos.LikesBehaviorDto;
import com.mark.model.behavior.pojos.ApBehaviorEntry;
import com.mark.model.behavior.pojos.ApLikesBehavior;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApBehaviorEntryMapper;
import com.mark.model.mappers.app.ApLikesBehaviorMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.common.BurstUtils;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description :  保存用户喜欢的行为
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 04:48$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 04:48$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@Service
@SuppressWarnings("all")
public class AppLikesBehaviorServiceImpl implements AppLikesBehaviorService {


    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApLikesBehaviorMapper apLikesBehaviorMapper;

    @Autowired
    private Sequences sequences;

    @Autowired
    private BehaviorMessageSender behaviorMessageSender;

    /**
     * 保存用户喜欢的行为
     * @param dto
     * @return
     */
    @Override
    public ResponseResult saveLikesBehavior(LikesBehaviorDto dto) {
        //获取用户信息，获取设备id
        ApUser user = AppThreadLocalUtils.getUser();
        //根据当前的用户信息或设备id查询行为实体 ap_behavior_entry
        if(user==null&&dto.getEquipmentId()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId = null;
        if(user!=null){
            userId=user.getId();
        }
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId,dto.getEquipmentId());
        if(apBehaviorEntry==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApLikesBehavior alb = new ApLikesBehavior();
        alb.setId(sequences.sequenceApLikes());
        alb.setBehaviorEntryId(apBehaviorEntry.getId());
        alb.setCreatedTime(new Date());
        alb.setEntryId(dto.getEntryId());
        alb.setType(dto.getType());
        alb.setOperation(dto.getOperation());
        alb.setBurst(BurstUtils.encrypt(alb.getId(),alb.getBehaviorEntryId()));

        int insert = apLikesBehaviorMapper.insert(alb);
        if(insert==1){
            if(alb.getOperation()==ApLikesBehavior.Operation.LIKE.getCode()){
                behaviorMessageSender.sendMessagePlus(new UserLikesMessage(alb),userId,true);
            }else if(alb.getOperation()==ApLikesBehavior.Operation.CANCEL.getCode()){
                behaviorMessageSender.sendMessageReduce(new UserLikesMessage(alb),userId,true);
            }
        }
        return ResponseResult.okResult(insert);
    }
}
