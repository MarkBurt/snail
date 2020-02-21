package com.mark.behavior.service;

import com.mark.model.behavior.dtos.ReadBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  存储阅读数据
 * @Author :  Markburt
 * @CreateDate :  2020/2/21$ 下午 11:15$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/21$ 下午 11:15$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppReadBehaviorService {

    /**
     *存储阅读数据
     * @param dto
     * @return
     */
    ResponseResult saveReadBehavior(ReadBehaviorDto dto);
}
