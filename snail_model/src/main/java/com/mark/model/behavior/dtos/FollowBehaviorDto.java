package com.mark.model.behavior.dtos;

import com.mark.model.annotation.IdEncrypt;
import lombok.Data;

/**
 * @author MAIBENBEN
 */
@Data
public class FollowBehaviorDto {
    /**
     * 设备ID
     */
    @IdEncrypt
    Integer equipmentId;
    /**
     * 文章ID
     */
    @IdEncrypt
    Integer articleId;
    /**
     * 跟踪Id
     */
    @IdEncrypt
    Integer followId;
}
