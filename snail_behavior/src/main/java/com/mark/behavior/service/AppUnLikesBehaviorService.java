package com.mark.behavior.service;

import com.mark.model.behavior.dtos.UnLikesBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/21$ 下午 11:04$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/21$ 下午 11:04$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface AppUnLikesBehaviorService {
    /**
     * 保存不喜欢的数据
     * @param dto
     * @return
     */
    ResponseResult saveUnLikesBehavior(UnLikesBehaviorDto dto);
}
