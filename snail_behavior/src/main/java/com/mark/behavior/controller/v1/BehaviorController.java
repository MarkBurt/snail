package com.mark.behavior.controller.v1;

import com.mark.behavior.apis.BehaviorControllerApi;
import com.mark.behavior.service.AppLikesBehaviorService;
import com.mark.behavior.service.AppReadBehaviorService;
import com.mark.behavior.service.AppShowBehaviorService;
import com.mark.behavior.service.AppUnLikesBehaviorService;
import com.mark.model.behavior.dtos.LikesBehaviorDto;
import com.mark.model.behavior.dtos.ReadBehaviorDto;
import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.behavior.dtos.UnLikesBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * 保存用户喜欢的行为
     */
    @Autowired
    private AppLikesBehaviorService appLikesBehaviorService;

    /**
     * 存储阅读数据
     */
    @Autowired
    private AppReadBehaviorService appReadBehaviorService;

    /**
     * 用户显示行为服务
     */
    @Autowired
    private AppShowBehaviorService appShowBehaviorService;

    /**
     * 保存用户不喜欢的行为
     */
    @Autowired
    private AppUnLikesBehaviorService appUnLikesBehaviorService;




    /**
     *用户显示行为服务
     * @param dto
     * @return
     */
    @Override
    @PostMapping("/show_behavior")
    public ResponseResult saveShowBehavior(@RequestBody ShowBehaviorDto dto) {
        return appShowBehaviorService.saveShowBehavior(dto);
    }

    /**
     * 保存用户喜欢的行为
     * @param dto
     * @return
     */
    @Override
    @PostMapping("/like_behavior")
    public ResponseResult saveLikesBehavior(@RequestBody LikesBehaviorDto dto) {
        return appLikesBehaviorService.saveLikesBehavior(dto);
    }

    /**
     * 保存用户不喜欢的行为
     * @param dto
     * @return
     */
    @Override
    @PostMapping("/unlike_behavior")
    public ResponseResult saveUnlikesBehavior(@RequestBody UnLikesBehaviorDto dto) {
        return appUnLikesBehaviorService.saveUnLikesBehavior(dto);
    }


    /**
     *存储阅读数据
     * @param dto
     * @return
     */

    @Override
    @PostMapping("/read_behavior")
    public ResponseResult saveReadBehavior(@RequestBody ReadBehaviorDto dto) {
        return appReadBehaviorService.saveReadBehavior(dto);
    }
}
