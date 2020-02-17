package com.mark.model.mappers.app;

import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.user.pojos.ApUser;
import com.mark.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApUserArticleListMapper {

    List<ApUserArticleList> loadArticleIdListByUser(@Param("user") ApUser user, @Param("dto") ArticleHomeDto dto, @Param("type") Short type);
}
