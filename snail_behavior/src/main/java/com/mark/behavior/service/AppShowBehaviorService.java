package com.mark.behavior.service;

import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  用户显示行为服务
 * @Author :  Markburt
 * @CreateDate :  2020/2/19$ 下午 02:47$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/19$ 下午 02:47$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppShowBehaviorService {

    /**
     * 保存用户行为
     * @param dto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);
}
