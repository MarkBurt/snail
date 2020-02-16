package com.mark.user.apis;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.dtos.UserRelationDto;

public interface UserRelationControllerApi {

    /**
     * 关注或取消关注
     */
    ResponseResult follow(UserRelationDto dto);
}
