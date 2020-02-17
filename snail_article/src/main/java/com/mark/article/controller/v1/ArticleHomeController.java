package com.mark.article.controller.v1;

import com.mark.article.apis.ArticleHomeControllerApi;
import com.mark.article.service.AppArticleService;
import com.mark.common.constans.ArticleConstans;
import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    private AppArticleService appArticleService;

    @Override
    @PostMapping("/load")
    public ResponseResult load(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadmore")
    public ResponseResult loadMore(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadnew")
    public ResponseResult loadNew(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_NEW);
    }
}
