package com.mark.behavior.apis;

import com.mark.model.behavior.dtos.LikesBehaviorDto;
import com.mark.model.behavior.dtos.ReadBehaviorDto;
import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.behavior.dtos.UnLikesBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;

public interface BehaviorControllerApi {

    /**
     * 保存用户点击文章的行为
     * @param dto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);

    /**
     * 保存点赞行为
     */
    ResponseResult saveLikesBehavior(LikesBehaviorDto dto);

    /**
     * 保存不喜欢行为数据
     */
    ResponseResult saveUnlikesBehavior(UnLikesBehaviorDto dto);

    /**
     * 保存或修改阅读行为数据
     */
    ResponseResult saveReadBehavior(ReadBehaviorDto dto);
}
