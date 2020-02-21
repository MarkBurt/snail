package com.mark.behavior.service.impl;

import com.mark.behavior.service.AppUnLikesBehaviorService;
import com.mark.model.behavior.dtos.UnLikesBehaviorDto;
import com.mark.model.behavior.pojos.ApBehaviorEntry;
import com.mark.model.behavior.pojos.ApUnlikesBehavior;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApBehaviorEntryMapper;
import com.mark.model.mappers.app.ApUnlikesBehaviorMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description :  保存不喜欢的数据的实现
 * @Author :  Markburt
 * @CreateDate :  2020/2/21$ 下午 11:05$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/21$ 下午 11:05$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@Service
@SuppressWarnings("all")
public class AppUnLikesBehaviorServiceImpl implements AppUnLikesBehaviorService {

    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApUnlikesBehaviorMapper apUnlikesBehaviorMapper;


    /**
     * 保存不喜欢的数据的实现
     * @param dto
     * @return
     */
    @Override
    public ResponseResult saveUnLikesBehavior(UnLikesBehaviorDto dto) {
        //获取用户信息，获取设备id
        ApUser user = AppThreadLocalUtils.getUser();
        //根据当前的用户信息或设备id查询行为实体 ap_behavior_entry
        if(user==null&&dto.getEquipmentId()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId = null;
        if(user!=null){
            userId=user.getId();
        }
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId,dto.getEquipmentId());
        if(apBehaviorEntry==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        ApUnlikesBehavior alb = new ApUnlikesBehavior();
        alb.setEntryId(apBehaviorEntry.getId());
        alb.setCreatedTime(new Date());
        alb.setArticleId(dto.getArticleId());
        alb.setType(dto.getType());
        int insert = apUnlikesBehaviorMapper.insert(alb);

        return ResponseResult.okResult(insert);
    }
}
