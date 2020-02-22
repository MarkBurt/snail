package com.mark.login.service;

import com.mark.model.user.pojos.ApUser;

/**
 * @Description :  验证服务
 * 对称加密  DES  AES
 * 散列算法 MD5  加盐 salt
 * @Author :  Markburt
 * @CreateDate :  2020/2/22$ 下午 07:42$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/22$ 下午 07:42$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface ValidateService {


    /**
     * DES验证
     * @param user
     * @param db
     * @return
     */
    boolean validateDES(ApUser user, ApUser db);

    /**
     * MD5验证
     * @param user
     * @param db
     * @return
     */
    boolean validateMD5(ApUser user,ApUser db);

    /**
     * MD5加盐验证
     * @param user
     * @param db
     * @return
     */
    boolean validateWithSalt(ApUser user,ApUser db);
}
