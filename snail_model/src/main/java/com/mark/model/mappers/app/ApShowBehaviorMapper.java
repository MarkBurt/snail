package com.mark.model.mappers.app;

import com.mark.model.behavior.pojos.ApShowBehavior;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApShowBehaviorMapper {


    /**
     * 按条目Id和项目Id选择列表
     * @param id
     * @param articleIds
     * @return
     */
    List<ApShowBehavior> selectListByEntryIdAndArticleIds(@Param("entryId") Integer id, @Param("articleIds") Integer[] articleIds);

    /**
     * 保存显示行为
     * @param articleIds
     * @param entryId
     */
    void saveShowBehavior(@Param("articleIds") Integer[] articleIds, @Param("entryId") Integer entryId);
}
