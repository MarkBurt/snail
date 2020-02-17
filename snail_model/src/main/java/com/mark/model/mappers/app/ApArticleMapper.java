package com.mark.model.mappers.app;

import com.mark.model.article.dtos.ArticleHomeDto;
import com.mark.model.article.pojos.ApArticle;
import com.mark.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApArticleMapper {


    /**
     * 加载默认的文章信息
     * @param dto
     * @param type
     * @return
     */
    List<ApArticle> loadArticleListByLocation(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);


    /**
     *
     * @param list
     * @return
     */
    List<ApArticle> loadArticleListByIdList(List<ApUserArticleList> list);

    /**
     *
     * @param id
     * @return
     */
    ApArticle selectById(Long id);


    /**
     *
     * @param apArticle
     */
    void insert(ApArticle apArticle);


    /**
     *
     * @param lastDay
     * @return
     */
    List<ApArticle> loadLastArticleForHot(String lastDay);

    /**
     * 更新文章数
     * @param articleId
     * @param viewCount
     * @param collectCount
     * @param commontCount
     * @param likeCount
     * @return
     */
    int updateArticleView(@Param("articleId") Integer articleId, @Param("viewCount") long viewCount, @Param("collectCount") long collectCount, @Param("commontCount") long commontCount, @Param("likeCount") long likeCount);

    /**
     * 依据文章IDS来获取文章详细内容
     * V2.0版本
     * @param list 文章ID
     * @return
     */
    List<ApArticle> loadArticleListByIdListV2(List<Integer> list);

    /**
     * 查询
     *
     * @param apArticle
     * @return
     */
    List<ApArticle> selectList(ApArticle apArticle);
    /**
     * 更新
     * @param apArticle
     */
    void updateSyncStatus(ApArticle apArticle);


}
