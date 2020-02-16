package com.mark.common.kafka.messages.app;

import com.mark.common.kafka.KafkaMessage;
import com.mark.model.article.pojos.ApHotArticles;

public class ApHotArticleMessage extends KafkaMessage<ApHotArticles> {

    public ApHotArticleMessage(){}

    public ApHotArticleMessage(ApHotArticles data){
        super(data);
    }

    @Override
    public String getType() {
        return "hot-article";
    }
}
