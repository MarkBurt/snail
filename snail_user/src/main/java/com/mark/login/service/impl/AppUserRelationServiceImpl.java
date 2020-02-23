package com.mark.login.service.impl;

import com.mark.common.zookeeper.sequence.Sequences;
import com.mark.login.service.AppFollowBehaviorService;
import com.mark.login.service.AppUserRelationService;
import com.mark.model.article.pojos.ApAuthor;
import com.mark.model.behavior.dtos.FollowBehaviorDto;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.common.enums.AppHttpCodeEnum;
import com.mark.model.mappers.app.ApAuthorMapper;
import com.mark.model.mappers.app.ApUserFanMapper;
import com.mark.model.mappers.app.ApUserFollowMapper;
import com.mark.model.mappers.app.ApUserMapper;
import com.mark.model.user.dtos.UserRelationDto;
import com.mark.model.user.pojos.ApUser;
import com.mark.model.user.pojos.ApUserFan;
import com.mark.model.user.pojos.ApUserFollow;
import com.mark.utils.common.BurstUtils;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description :  java类作用描述
 * @Author :  Markburt
 * @CreateDate :  2020/2/23$ 下午 01:45$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/23$ 下午 01:45$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Service
@SuppressWarnings("all")
public class AppUserRelationServiceImpl implements AppUserRelationService {


    @Autowired
    private ApAuthorMapper apAuthorMapper;

    @Autowired
    private ApUserMapper apUserMapper;

    @Autowired
    private ApUserFollowMapper apUserFollowMapper;

    @Autowired
    private ApUserFanMapper apUserFanMapper;

    @Autowired
    private Sequences sequences;

    @Autowired
    private AppFollowBehaviorService appFollowBehaviorService;

    /**
     * 用户的关注或取消关注
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult follow(UserRelationDto dto) {
        if (dto.getOperation() == null || dto.getOperation() < 0 || dto.getOperation() > 1) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE, "无效的operation参数");
        }
        //获取到followId
        Integer followid = dto.getUserId();
        if (followid == null && dto.getAuthorId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE, "followId或authorId不能同时为空");
        } else if (followid == null) {
            ApAuthor apAuthor = apAuthorMapper.selectById(dto.getAuthorId());

            if (apAuthor == null) {

                followid = apAuthor.getId().intValue();
            }
        }

        if (followid == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "关注人不存在或没有关注");
        } else {
            //判断当前用户是否已经关注
            ApUser apUser = AppThreadLocalUtils.getUser();
            if (apUser != null) {
                if (dto.getOperation() == 0) {
                    //关注操作
                    //保存ap_user_follow  ap_user_fan  保存关注的行为
                    return followByUserId(apUser, followid, dto.getArticleId());
                } else {
                    //取消关注
                    //删除ap_user_follow  ap_user_fan
                    return followCancelByUserId(apUser, followid);
                }
            } else {
                return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            }
        }
    }


    /**
     * 处理关注的逻辑
     * 保存ap_user_follow  ap_user_fan  保存关注的行为
     *
     * @param user
     * @param followId
     * @param articleId
     * @return
     */
    private ResponseResult followByUserId(ApUser user, Integer followId, Integer articleId) {
        ApUser apUser = apUserMapper.selectById(followId);

        if(apUser==null){

            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"关注用户不存在");
        }

        ApUserFollow apUserFollow = apUserFollowMapper.selectByFollowId(BurstUtils.groudOne(user.getId()), user.getId(), followId);

        if(apUserFollow==null){

            ApUserFan apUserFan = apUserFanMapper.selectByFansId(BurstUtils.groudOne(followId), followId, user.getId());

            if(apUserFan==null){

                apUserFan= new ApUserFan();
                apUserFan.setId(sequences.sequenceApUserFan());
                apUserFan.setUserId(followId);
                apUserFan.setFansId(user.getId());
                apUserFan.setFansName(user.getName());
                apUserFan.setLevel((short) 0);
                apUserFan.setIsDisplay(true);
                apUserFan.setIsShieldComment(false);
                apUserFan.setIsShieldLetter(false);
                apUserFan.setBurst(BurstUtils.encrypt(apUserFan.getId(), apUserFan.getUserId()));

                apUserFanMapper.insert(apUserFan);
            }
            apUserFollow= new ApUserFollow();

            apUserFollow.setId(sequences.sequenceApUserFollow());
            apUserFollow.setUserId(user.getId());
            apUserFollow.setFollowId(followId);
            apUserFollow.setFollowName(apUser.getName());
            apUserFollow.setCreatedTime(new Date());
            apUserFollow.setLevel((short) 0);
            apUserFollow.setIsNotice(true);
            apUserFollow.setBurst(BurstUtils.encrypt(apUserFollow.getId(),apUserFollow.getUserId()));

            //记录用户关注的行为
            FollowBehaviorDto dto = new FollowBehaviorDto();
            dto.setFollowId(followId);
            dto.setArticleId(articleId);

            appFollowBehaviorService.saveFollowBehavior(dto);

            int insert = apUserFollowMapper.insert(apUserFollow);

            return ResponseResult.okResult(insert);

        }else{

            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST,"已关注");

        }
    }


    /**
     *处理取消关注的逻辑
     * @param user
     * @param followId
     * @return
     */
    private ResponseResult followCancelByUserId(ApUser user, Integer followId) {

        ApUserFollow apUserFollow = apUserFollowMapper.selectByFollowId(BurstUtils.groudOne(user.getId()), user.getId(), followId);

        if(apUserFollow==null){

            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"未关注");

        }else{

            ApUserFan apUserFan = apUserFanMapper.selectByFansId(BurstUtils.groudOne(followId), followId, user.getId());

            if(apUserFan!=null){

                apUserFanMapper.deleteByFansId(BurstUtils.groudOne(followId),followId,user.getId());

            }

            int count = apUserFollowMapper.deleteByFollowId(BurstUtils.groudOne(user.getId()), user.getId(), followId);

            return ResponseResult.okResult(count);
        }
    }


}
