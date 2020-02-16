package com.mark.model.mappers.app;

import com.mark.model.behavior.pojos.ApReadBehavior;
import org.apache.ibatis.annotations.Param;

public interface ApReadBehaviorMapper {
    int insert(ApReadBehavior record);
    int update(ApReadBehavior record);
    ApReadBehavior selectByEntryId(@Param("burst") String burst, @Param("entryId") Integer entryId, @Param("articleId") Integer articleId);
}