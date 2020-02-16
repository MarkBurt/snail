package com.mark.article.apis;

import com.mark.model.article.dtos.ArticleInfoDto;
import com.mark.model.common.dtos.ResponseResult;

public interface ArticleInfoControllerApi {

    public ResponseResult loadArticleInfo(ArticleInfoDto dto);

    ResponseResult loadArticleBehavior(ArticleInfoDto dto);
}
