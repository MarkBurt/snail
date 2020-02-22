package com.mark.login.service.impl;

import com.mark.login.service.ValidateService;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.common.DESUtils;
import com.mark.utils.common.MD5Utils;

/**
 * @Description :  验证服务
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 08:41$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 08:41$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public class ValidateServiceImpl implements ValidateService {


    /**
     * DES验证
     * @param user
     * @param db
     * @return
     */
    @Override
    public boolean validateDES(ApUser user, ApUser db) {

        if(db.getPassword().equals(DESUtils.encode(user.getPassword()))){
            return true;
        }
        return false;
    }

    /**
     * MD5验证
     * @param user
     * @param db
     * @return
     */
    @Override
    public boolean validateMD5(ApUser user, ApUser db) {

        if (db.getPassword().equals(MD5Utils.encode(user.getPassword()))){
            return  true;
        }
        return false;
    }

    /**
     * MD5加盐验证
     * @param user
     * @param db
     * @return
     */
    @Override
    public boolean validateWithSalt(ApUser user, ApUser db) {

        if (db.getPassword().equals(MD5Utils.encodeWithSalt(user.getPassword(),db.getSalt()))){
            return  true;
        }
        return false;
    }
}
