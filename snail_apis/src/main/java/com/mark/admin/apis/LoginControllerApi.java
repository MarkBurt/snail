package com.mark.admin.apis;

import com.mark.model.admin.pojos.AdUser;
import com.mark.model.common.dtos.ResponseResult;

public interface LoginControllerApi {

    /**
     * 登录
     * @param user
     * @return
     */
    public ResponseResult login(AdUser user);
}
