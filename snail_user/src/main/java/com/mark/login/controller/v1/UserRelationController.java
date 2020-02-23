package com.mark.login.controller.v1;

import com.mark.login.service.AppUserRelationService;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.user.dtos.UserRelationDto;
import com.mark.user.apis.UserRelationControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :  用户关系控制器
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 01:38$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 01:38$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRelationController implements UserRelationControllerApi {


    @Autowired
    private AppUserRelationService appUserRelationService;

    /**
     * 用户关注接口
     * @param dto
     * @return
     */
    @Override
    @PostMapping("/user_follow")
    public ResponseResult follow(UserRelationDto dto) {
        return appUserRelationService.follow(dto);
    }
}
