package com.mark.model.mappers.app;

import com.mark.model.article.pojos.ApAuthor;

import java.util.List;

/**
 * @author MAIBENBEN
 */
public interface ApAuthorMapper {
    /**
     *
     * @param id
     * @return
     */
    ApAuthor selectById(Integer id);

    /**
     *
     * @param authorName
     * @return
     */
    ApAuthor selectByAuthorName(String authorName);

    /**
     *
     * @param apAuthor
     */
    void insert(ApAuthor apAuthor);

    /**
     *
     * @param ids
     * @return
     */
    List<ApAuthor> selectByIds(List<Integer> ids);
}