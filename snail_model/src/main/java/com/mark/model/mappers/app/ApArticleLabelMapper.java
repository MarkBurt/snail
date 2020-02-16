package com.mark.model.mappers.app;

import com.mark.model.article.pojos.ApArticleLabel;

import java.util.List;

public interface ApArticleLabelMapper {
    
    int insert(ApArticleLabel record);

    int insertSelective(ApArticleLabel record);

    int updateByPrimaryKeySelective(ApArticleLabel record);

    List<ApArticleLabel> selectList(ApArticleLabel apArticleLabel);
}