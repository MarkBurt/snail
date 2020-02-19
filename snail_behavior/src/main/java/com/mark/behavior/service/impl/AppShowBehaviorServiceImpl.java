package com.mark.behavior.service.impl;

import com.mark.behavior.service.AppShowBehaviorService;
import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.stereotype.Service;

/**
 * @Description :  显示用户行为服务
 * @Author :  Markburt
 * @CreateDate :  2020/2/19$ 下午 02:49$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/19$ 下午 02:49$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Service
@SuppressWarnings("all")
public class AppShowBehaviorServiceImpl implements AppShowBehaviorService {

    /**
     * 保存用户行为服务的实现
     * @param dto
     * @return
     */
    @Override
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        //获取获取线程中的用户 , 设备id及用户信息
        ApUser user = AppThreadLocalUtils.getUser();
        //根据当前的用户信息或设备id查询行为实体 ap_behavior_entry
        if (user==null && dto.getEquipmentId()==null){
            //返回缺少参数
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }


        return null;
    }
}
