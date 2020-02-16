package com.mark.model.mappers.wemedia;

import com.mark.model.media.dtos.StatisticDto;
import com.mark.model.media.pojos.WmNewsStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmNewsStatisticsMapper {
	List<WmNewsStatistics> findByTimeAndUserId(@Param("burst") String burst, @Param("userId") Long userId,
                                               @Param("dto") StatisticDto dto);
}