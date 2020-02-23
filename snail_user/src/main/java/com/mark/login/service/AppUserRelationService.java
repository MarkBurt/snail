package com.mark.login.service;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.dtos.UserRelationDto;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 01:40$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 01:40$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppUserRelationService {

    /**
     *用户的关注或取消关注
     * @param dto
     * @return
     */
    ResponseResult follow(UserRelationDto dto);
}
