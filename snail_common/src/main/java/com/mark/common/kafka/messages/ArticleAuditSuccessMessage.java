package com.mark.common.kafka.messages;

import com.mark.common.kafka.KafkaMessage;
import com.mark.model.mess.admin.ArticleAuditSuccess;

/**
 * 审核成功发送消息
 */
public class ArticleAuditSuccessMessage extends KafkaMessage<ArticleAuditSuccess> {

    public ArticleAuditSuccessMessage() {
    }

    public ArticleAuditSuccessMessage(ArticleAuditSuccess data) {
        super(data);
    }

    @Override
    public String getType() {
        return "admin_audit_success";
    }

}