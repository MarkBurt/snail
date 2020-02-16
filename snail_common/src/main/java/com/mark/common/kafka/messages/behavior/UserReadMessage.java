package com.mark.common.kafka.messages.behavior;

import com.mark.common.kafka.KafkaMessage;
import com.mark.model.behavior.pojos.ApReadBehavior;

public class UserReadMessage extends KafkaMessage<ApReadBehavior> {

    public UserReadMessage(){}

    public UserReadMessage(ApReadBehavior data){
        super(data);
    }

    @Override
    public String getType() {
        return "user-read";
    }
}
