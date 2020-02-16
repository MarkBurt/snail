package com.mark.model.mappers.app;

import com.mark.model.user.pojos.ApUser;

public interface ApUserMapper {
    ApUser selectById(Integer id);

    ApUser selectByApPhone(String phone);
}