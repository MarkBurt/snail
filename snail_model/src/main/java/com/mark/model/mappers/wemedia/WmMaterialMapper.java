package com.mark.model.mappers.wemedia;

import com.mark.model.media.dtos.WmMaterialListDto;
import com.mark.model.media.pojos.WmMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface WmMaterialMapper {
    int insert(WmMaterial record);

    WmMaterial selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    List<WmMaterial> findListByUidAndStatus(@Param("dto") WmMaterialListDto dto, @Param("uid") Long uid);

    int countListByUidAndStatus(@Param("dto") WmMaterialListDto dto, @Param("uid") Long uid);

    int updateStatusByUidAndId(@Param("id") Integer id, @Param("userId") Long userId, @Param("type") Short type);
    List<WmMaterial> findMaterialByUidAndimgUrls(@Param("uid") Long uid, @Param("values") Collection<Object> values);


}