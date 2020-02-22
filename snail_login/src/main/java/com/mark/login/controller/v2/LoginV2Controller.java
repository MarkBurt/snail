package com.mark.login.controller.v2;

import com.mark.login.apis.LoginControllerApi;
import com.mark.login.service.ApUserLoginService;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.pojos.ApUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :  用户登录接口控制
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 08:57$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 08:57$
 * @UpdateRemark :  Project Build
 * @Version :  2.0
 */
@RestController
@RequestMapping("/api/v2/login")
public class LoginV2Controller implements LoginControllerApi {

    @Autowired
    private ApUserLoginService apUserLoginService;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @Override
    @PostMapping("/login_auth")
    public ResponseResult login(@RequestBody ApUser user) {
        return apUserLoginService.loginAuthV2(user);
    }
}
