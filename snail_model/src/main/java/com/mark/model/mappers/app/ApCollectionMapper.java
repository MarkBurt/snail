package com.mark.model.mappers.app;

import com.mark.model.article.pojos.ApCollection;
import org.apache.ibatis.annotations.Param;

public interface ApCollectionMapper {
    /**
     * 选择一个终端的收藏数据
     * @return
     */
    ApCollection selectForEntryId(@Param("burst") String burst, @Param("objectId") Integer objectId, @Param("entryId") Integer entryId, @Param("type") Short type);
}