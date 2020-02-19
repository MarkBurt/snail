package com.mark.behavior.service.impl;

import com.mark.behavior.service.AppShowBehaviorService;
import com.mark.model.behavior.dtos.ShowBehaviorDto;
import com.mark.model.behavior.pojos.ApBehaviorEntry;
import com.mark.model.behavior.pojos.ApShowBehavior;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApBehaviorEntryMapper;
import com.mark.model.mappers.app.ApShowBehaviorMapper;
import com.mark.model.user.pojos.ApUser;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description :  显示用户行为服务🎁
 * @Author :  Markburt🎁🎁
 * @CreateDate :  2020/2/19$ 下午 02:49$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/19$ 下午 02:49$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Service
@SuppressWarnings("all")
public class AppShowBehaviorServiceImpl implements AppShowBehaviorService {


    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApShowBehaviorMapper apShowBehaviorMapper;

    /**
     * 保存用户行为服务的实现
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        //获取获取线程中的用户 , 设备id及用户信息
        ApUser user = AppThreadLocalUtils.getUser();
        //根据当前的用户信息或设备id查询行为实体 ap_behavior_entry
        if (user == null && dto.getEquipmentId() == null) {
            //返回缺少参数
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        //u
        Long userid = null;
        if (user != null) {
            userid = user.getId();
        }
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userid, dto.getEquipmentId());

        if (apBehaviorEntry == null) {
            //返回无效参数
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //获取前台传递过来的文章列表id
        Integer[] articleIds = new Integer[dto.getArticleIds().size()];
        for (int i = 0; i < articleIds.length; i++) {
            articleIds[i] = dto.getArticleIds().get(i).getId();
        }
        //根据行为实体id和文章列表id查询app行为表  ap_show_behavior
        List<ApShowBehavior> apShowBehaviors = apShowBehaviorMapper.selectListByEntryIdAndArticleIds(
                apBehaviorEntry.getId(),
                articleIds);
        //数据的过滤，需要删除表中已经存在的文章id
        List<Integer> integers = new ArrayList<>(Arrays.asList(articleIds));
        if (!apShowBehaviors.isEmpty()) {
            apShowBehaviors.forEach(itemm -> {
                Integer articleId = itemm.getArticleId();
                integers.remove(articleId);

            });
        }

        /**
         * 保存
         */

        if (!integers.isEmpty()) {
            articleIds = new Integer[integers.size()];
            integers.toArray(articleIds);
            apShowBehaviorMapper.saveShowBehavior(articleIds, apBehaviorEntry.getId());
        }

        return ResponseResult.okResult(0);
    }
}
