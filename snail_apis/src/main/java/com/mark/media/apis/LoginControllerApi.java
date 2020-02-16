package com.mark.media.apis;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.media.pojos.WmUser;

public interface LoginControllerApi {

    public ResponseResult login(WmUser user);
}
