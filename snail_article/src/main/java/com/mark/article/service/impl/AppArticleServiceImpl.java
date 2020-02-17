package com.mark.article.service.impl;

import com.mark.article.service.AppArticleService;
import com.mark.common.constans.ArticleConstans;
import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.article.pojos.ApArticle;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.mappers.app.ApArticleMapper;
import com.mark.model.mappers.app.ApUserArticleListMapper;
import com.mark.model.mess.app.ArticleVisitStreamDto;
import com.mark.model.user.pojos.ApUser;
import com.mark.model.user.pojos.ApUserArticleList;
import com.mark.utils.threadlocal.AppThreadLocalUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description :  文章的实现
 * @Author :  Markburt
 * @CreateDate :  2020/2/17$ 下午 12:24$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/17$ 下午 12:24$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
@Service
@Log4j2
@SuppressWarnings("all")
public class AppArticleServiceImpl implements AppArticleService {

    /**
     * 最大页面显示条数
     */
    private static final short MAX_PAGE_SIZE = 50;

    @Autowired
    private ApUserArticleListMapper apUserArticleListMapper;

    @Autowired
    private ApArticleMapper apArticleMapper;


    /**
     *
     * @param dto
     * @param type
     * @return
     */
    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {
        //参数校验
        if(dto ==null ){
            dto = new ArticleHomeDto();
        }
        //时间校验
        if(dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }

        if(dto.getMinBehotTime()==null){
            dto.setMinBehotTime(new Date());
        }

        //分页参数的校验
        Integer size = dto.getSize();
        if(size==null || size <= 0){
            size = 20;
        }
        size = Math.min(size,MAX_PAGE_SIZE);
        dto.setSize(size);

        //文章频道参数校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstans.DEFAULT_TAG);
        }

        //类型参数校验
        if(!type.equals(ArticleConstans.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstans.LOADTYPE_LOAD_NEW)){
            type = ArticleConstans.LOADTYPE_LOAD_MORE;
        }

        //获取用户的信息
        ApUser user = AppThreadLocalUtils.getUser();

        //判断用户是否存在
        if(user != null){
            //存在 已登录 加载推荐的文章
            List<ApArticle> apArticleList = getUserArticle(user,dto,type);
            return ResponseResult.okResult(apArticleList);
        }else{
            //不存在 未登录，加载默认的文章
            List<ApArticle> apArticles = getDefaultArticle(dto,type);
            return ResponseResult.okResult(apArticles);
        }

    }


    /**
     * 先从用户的推荐表中查找文章信息，如果没有再从默认文章信息获取数据
     * @param user
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getUserArticle(ApUser user, ArticleHomeDto dto, Short type) {
        List<ApUserArticleList> list = apUserArticleListMapper.loadArticleIdListByUser(user,dto,type);
        if(!list.isEmpty()){
            return apArticleMapper.loadArticleListByIdList(list);
        }else{
            return getDefaultArticle(dto,type);
        }
    }




    /**
     * 加载默认的文章信息
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getDefaultArticle(ArticleHomeDto dto, Short type) {
        return apArticleMapper.loadArticleListByLocation(dto,type);
    }

    /**
     *更新 点赞 阅读数
     * @param dto
     * @return
     */
    @Override
    public ResponseResult updateArticleView(ArticleVisitStreamDto dto) {
        int rows = apArticleMapper.updateArticleView(
                dto.getArticleId(),
                dto.getView(),
                dto.getCollect(),
                dto.getCommont(),
                dto.getLike()
        );
        return ResponseResult.okResult(rows);
    }

    /**
     *
     * @param type
     * @param dto
     * @param firstPage
     * @return
     */
    @Override
    public ResponseResult loadV2(Short type, ArticleHomeDto dto, boolean firstPage) {
        return null;
    }
}
