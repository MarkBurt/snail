package com.mark.article.service;

import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.mess.app.ArticleVisitStreamDto;
import org.springframework.stereotype.Repository;

/**
 * @Description :  文章的service
 * @Author :  Markburt
 * @CreateDate :  2020/2/17$ 下午 12:22$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/17$ 下午 12:22$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
//防止impl及controller报错
@Repository
public interface AppArticleService {

    /**
     * type  1 加载更多  2 加载更新
     * @param dto
     * @param type
     * @return
     */
    ResponseResult load(ArticleHomeDto dto, Short type);

    /**
     * 更新 点赞 阅读数
     * @param dto
     * @return
     */
    ResponseResult updateArticleView(ArticleVisitStreamDto dto);

    /**
     * 加载文章列表数据
     * @param type
     * @param dto
     * @param firstPage
     * @return
     */
    ResponseResult loadV2(Short type, ArticleHomeDto dto, boolean firstPage);
}
