package com.mark.login.service;

import com.mark.model.behavior.dtos.FollowBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 05:52$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 05:52$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppFollowBehaviorService {

    /***
     *存储关注行为数据
     * @param dto
     * @return
     */
    ResponseResult saveFollowBehavior(FollowBehaviorDto dto);
}
