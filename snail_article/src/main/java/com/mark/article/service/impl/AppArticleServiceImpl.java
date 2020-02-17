package com.mark.article.service.impl;

import com.mark.article.service.AppArticleService;
import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.mess.app.ArticleVisitStreamDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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

    /**
     *
     * @param dto
     * @param type
     * @return
     */
    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {
        return null;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult updateArticleView(ArticleVisitStreamDto dto) {
        return null;
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
