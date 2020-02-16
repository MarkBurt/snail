package com.mark.login.apis;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.pojos.ApUser;

public interface LoginControllerApi {

    ResponseResult login(ApUser user);
}
