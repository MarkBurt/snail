package com.mark.article.apis;

import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.common.dtos.ResponseResult;

/**
 * @Description :  文章接口
 * @Author :  Markburt
 * @CreateDate :  2020/2/17$ 下午 12:06$
 * @UpdateUser :  Markburt
 * @UpdateDate :  2020/2/17$ 下午 12:06$
 * @UpdateRemark :  Project Build
 * @Version :  1.0
 */
public interface ArticleHomeControllerApi {

    /**
     * 加载首页文章
     * @param dto
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto);

    /**
     * 加载更多
     * @param dto
     * @return
     */
    public ResponseResult loadMore(ArticleHomeDto dto);

    /**
     * 加载最新的文章信息
     * @param dto
     * @return
     */
    public ResponseResult loadNew(ArticleHomeDto dto);
}
