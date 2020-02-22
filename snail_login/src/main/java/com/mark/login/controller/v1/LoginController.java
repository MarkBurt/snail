package com.mark.login.controller.v1;


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
 * @CreateDate :  2020/2/22$ 下午 08:49$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 08:49$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@RestController
@RequestMapping("/api/v1/login")
public class LoginController implements LoginControllerApi {

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
        return apUserLoginService.loginAuth(user);
    }
}
