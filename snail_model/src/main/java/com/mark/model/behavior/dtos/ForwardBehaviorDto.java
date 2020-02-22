package com.mark.model.behavior.dtos;

import com.mark.model.annotation.IdEncrypt;
import lombok.Data;

/**
 * @author MAIBENBEN
 */
@Data
public class ForwardBehaviorDto {
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
     * 动态Id
     */
    @IdEncrypt
    Integer dynamicId;
}
