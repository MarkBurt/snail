package com.mark.behavior.controller.v1;

import com.mark.behavior.apis.BehaviorControllerApi;
import com.mark.model.behavior.dtos.LikesBehaviorDto;
import com.mark.model.behavior.dtos.ReadBehaviorDto;
import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.behavior.dtos.UnLikesBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/19$ 下午 02:45$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/19$ 下午 02:45$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@RestController
@RequestMapping("/api/v1/behavior")
public class BehaviorController implements BehaviorControllerApi {




    @Override
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        return null;
    }

    @Override
    public ResponseResult saveLikesBehavior(LikesBehaviorDto dto) {
        return null;
    }

    @Override
    public ResponseResult saveUnlikesBehavior(UnLikesBehaviorDto dto) {
        return null;
    }

    @Override
    public ResponseResult saveReadBehavior(ReadBehaviorDto dto) {
        return null;
    }
}
