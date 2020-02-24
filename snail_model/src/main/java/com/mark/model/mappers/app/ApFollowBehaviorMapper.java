package com.mark.model.mappers.app;

import com.mark.model.behavior.pojos.ApFollowBehavior;

/**
 * @author MAIBENBEN
 */
public interface ApFollowBehaviorMapper {
    /**
     * 存储关注行为数据信息
     * @param record
     * @return
     */
    int insert(ApFollowBehavior record);
}