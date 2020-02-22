package com.mark.login.service.impl;

import com.mark.login.service.ApUserLoginService;
import com.mark.login.service.ValidateService;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApUserMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.jwt.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :  根据用户名和密码登录验证
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 07:40$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 07:40$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@Service
@SuppressWarnings("all")
public class ApUserLoginServiceImpl implements ApUserLoginService {


    @Autowired
    private ApUserMapper apUserMapper;

    @Autowired
    private ValidateService validateService;

    /***
     * 根据用户名和密码登录验证
     * @param user
     * @return
     */
    @Override
    public ResponseResult loginAuth(ApUser user) {
        //验证参数
        if (StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApUser apUser = apUserMapper.selectByApPhone(user.getPhone());
        if (apUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        if (!user.getPassword().equals(apUser.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        apUser.setPassword("");
        Map<String, Object> map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(apUser));
        map.put("user", apUser);

        return ResponseResult.okResult(map);
    }

}