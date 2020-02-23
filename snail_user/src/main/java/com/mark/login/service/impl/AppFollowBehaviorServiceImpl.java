package com.mark.login.service.impl;

import com.mark.login.service.AppFollowBehaviorService;
import com.mark.model.behavior.dtos.FollowBehaviorDto;
import com.mark.model.behavior.pojos.ApBehaviorEntry;
import com.mark.model.behavior.pojos.ApFollowBehavior;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApBehaviorEntryMapper;
import com.mark.model.mappers.app.ApFollowBehaviorMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 05:53$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 05:53$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Service
@SuppressWarnings("all")
public class AppFollowBehaviorServiceImpl implements AppFollowBehaviorService {
    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApFollowBehaviorMapper apFollowBehaviorMapper;

    /**
     *存储关注行为数据
     * @param dto
     * @return
     */
    @Override
    @Async
    public ResponseResult saveFollowBehavior(FollowBehaviorDto dto) {
        //int a = 1/0;
        ApUser apUser = AppThreadLocalUtils.getUser();
        if(apUser==null &&dto.getEquipmentId()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId = null;
        if(apUser!=null){
            userId = apUser.getId();
        }
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId, dto.getEquipmentId());
        if(apBehaviorEntry==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //保存行为
        ApFollowBehavior apFollowBehavior = new ApFollowBehavior();
        apFollowBehavior.setEntryId(apBehaviorEntry.getId());
        apFollowBehavior.setArticleId(dto.getArticleId());
        apFollowBehavior.setFollowId(dto.getFollowId());
        apFollowBehavior.setCreatedTime(new Date());
        int insert = apFollowBehaviorMapper.insert(apFollowBehavior);
        return ResponseResult.okResult(insert);
    }
}
