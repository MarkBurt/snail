package com.mark.model.mappers.app;

import com.mark.model.user.pojos.ApUser;

/**
 * @author MAIBENBEN
 */
public interface ApUserMapper {

    /**
     * 用户名是否存在且正确
     * @param id
     * @return
     */
    ApUser selectById(Integer id);

    /**
     *手机号是否存在
     * @param phone
     * @return
     */
    ApUser selectByApPhone(String phone);
}