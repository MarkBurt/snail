package com.mark.common.kafka.messages.app;

import com.mark.common.kafka.KafkaMessage;
import com.mark.model.mess.app.ArticleVisitStreamDto;

public class ArticleVisitStreamMessage extends KafkaMessage<ArticleVisitStreamDto> {

    public ArticleVisitStreamMessage(){}

    public ArticleVisitStreamMessage(ArticleVisitStreamDto data){
        super(data);
    }

    @Override
    public String getType() {
        return "article-visit-stream";
    }
}
