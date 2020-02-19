package com.mark.model.mappers.app;

import com.mark.model.behavior.pojos.ApBehaviorEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApBehaviorEntryMapper {

    /**
     * 按用户Id或设备Id选择
     * @param userId
     * @param equipmentId
     * @return
     */
    ApBehaviorEntry selectByUserIdOrEquipemntId(@Param("userId") Long userId, @Param("equipmentId") Integer equipmentId);

    /**
     * 全选条目
     * @return
     */
    List<ApBehaviorEntry> selectAllEntry();
}
