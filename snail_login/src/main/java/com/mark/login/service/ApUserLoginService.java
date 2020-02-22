package com.mark.login.service;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.pojos.ApUser;

/**
 * @Description :  用户登录验证
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 07:39$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 07:39$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface ApUserLoginService {

    /**
     *根据用户名和密码登录验证
     * @param user
     * @return
     */
    ResponseResult loginAuth(ApUser user);



    /**
     * 根据用户名和密码登录验证  V2
     */
    ResponseResult loginAuthV2(ApUser user);
}
