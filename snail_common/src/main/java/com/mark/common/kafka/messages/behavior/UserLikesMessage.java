package com.mark.common.kafka.messages.behavior;

import com.mark.common.kafka.KafkaMessage;
import com.mark.model.behavior.pojos.ApLikesBehavior;

public class UserLikesMessage extends KafkaMessage<ApLikesBehavior> {

    public UserLikesMessage(){}

    public UserLikesMessage(ApLikesBehavior data){
        super(data);
    }

    @Override
    public String getType() {
        return "user-likes";
    }
}
