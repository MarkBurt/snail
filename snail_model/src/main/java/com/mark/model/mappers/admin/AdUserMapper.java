package com.mark.model.mappers.admin;

import com.mark.model.admin.pojos.AdUser;

public interface AdUserMapper {

    AdUser selectByName(String name);
}