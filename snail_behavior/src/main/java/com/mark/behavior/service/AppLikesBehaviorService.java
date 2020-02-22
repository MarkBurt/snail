package com.mark.behavior.service;

import com.mark.model.behavior.dtos.LikesBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  保存用户喜欢的行为
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 上午 11:38$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 上午 11:38$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppLikesBehaviorService {

    /**
     * 保存用户喜欢的行为
     * @param dto
     * @return
     */
    ResponseResult saveLikesBehavior(LikesBehaviorDto dto);
}
