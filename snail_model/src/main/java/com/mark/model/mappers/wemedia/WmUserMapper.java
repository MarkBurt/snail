package com.mark.model.mappers.wemedia;

import com.mark.model.media.pojos.WmUser;

public interface WmUserMapper {
    WmUser selectByName(String name);

    WmUser selectById(Long id);
}