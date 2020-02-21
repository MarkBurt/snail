package com.mark.behavior.service.impl;

import com.mark.behavior.kafka.BehaviorMessageSender;
import com.mark.behavior.service.AppReadBehaviorService;
import com.mark.common.kafka.messages.behavior.UserReadMessage;
import com.mark.common.zookeeper.sequence.Sequences;
import com.mark.model.behavior.dtos.ReadBehaviorDto;
import com.mark.model.behavior.pojos.ApBehaviorEntry;
import com.mark.model.behavior.pojos.ApReadBehavior;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApBehaviorEntryMapper;
import com.mark.model.mappers.app.ApReadBehaviorMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.common.BurstUtils;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description :  存储阅读数据
 * @Author :  Markburt
 * @CreateDate :  2020/2/21$ 下午 11:16$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/21$ 下午 11:16$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */

@Service
@SuppressWarnings("all")
public class AppReadBehaviorServiceImpl implements AppReadBehaviorService {


    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApReadBehaviorMapper apReadBehaviorMapper;

    @Autowired
    private Sequences sequences;

    @Autowired
    private BehaviorMessageSender behaviorMessageSender;


    /**
     * 存储阅读数据
     * @param dto
     * @return
     */
    @Override
    public ResponseResult saveReadBehavior(ReadBehaviorDto dto) {
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
        //查询
        ApReadBehavior apReadBehavior = apReadBehaviorMapper.selectByEntryId(BurstUtils.groudOne(apBehaviorEntry.getId()), apBehaviorEntry.getId(), dto.getArticleId());
        boolean isInsert = false;
        if(apReadBehavior==null){
            isInsert = true;
            apReadBehavior= new ApReadBehavior();
            apReadBehavior.setId(sequences.sequenceApReadBehavior());
        }
        apReadBehavior.setEntryId(apBehaviorEntry.getId());
        apReadBehavior.setCount(dto.getCount());
        apReadBehavior.setPercentage(dto.getPercentage());
        apReadBehavior.setLoadDuration(dto.getLoadDuration());
        apReadBehavior.setArticleId(dto.getArticleId());
        apReadBehavior.setUpdatedTime(new Date());
        apReadBehavior.setCreatedTime(new Date());
        apReadBehavior.setReadDuration(dto.getReadDuration());
        apReadBehavior.setBurst(BurstUtils.encrypt(apReadBehavior.getId(),apReadBehavior.getEntryId()));
        int count = 0;
        if(isInsert){
            count= apReadBehaviorMapper.insert(apReadBehavior);
            if(count==1){
                behaviorMessageSender.sendMessagePlus(new UserReadMessage(apReadBehavior),userId,true);
            }
        }else{
            count =apReadBehaviorMapper.update(apReadBehavior);
        }

        return ResponseResult.okResult(count);
    }
}
