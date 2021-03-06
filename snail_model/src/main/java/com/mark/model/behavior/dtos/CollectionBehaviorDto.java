package com.mark.model.behavior.dtos;

import com.mark.model.annotation.IdEncrypt;
import lombok.Data;

import java.util.Date;

/**
 * @author MAIBENBEN
 */
@Data
public class CollectionBehaviorDto {
    /**
     * 设备ID
     */
    @IdEncrypt
    Integer equipmentId;
    /**
     * 文章、动态ID
     */
    @IdEncrypt
    Integer entryId;
    /**
     * 收藏内容类型
     * 0文章
     * 1动态
     */
    Short type;

    /**
     * 操作类型
     * 0收藏
     * 1取消收藏
     */
    Short operation;

    /**
     * 公布时间
     */
    Date publishedTime;

}
