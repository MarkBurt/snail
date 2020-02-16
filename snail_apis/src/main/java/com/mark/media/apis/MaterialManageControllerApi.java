package com.mark.media.apis;

import com.mark.model.common.dtos.ResponseResult;
import com.mark.model.media.dtos.WmMaterialDto;
import com.mark.model.media.dtos.WmMaterialListDto;
import org.springframework.web.multipart.MultipartFile;

public interface MaterialManageControllerApi {

    /**
     * 上传图片
     * @param file
     * @return
     */
    public ResponseResult uploadPicture(MultipartFile file);

    /**
     * 删除图片
     * @param dto
     * @return
     */
    public ResponseResult delPicture(WmMaterialDto dto);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    public ResponseResult list(WmMaterialListDto dto);

    /**
     * 收藏
     * @param dto
     * @return
     */
    public ResponseResult collectionMaterial(WmMaterialDto dto);

    /**
     * 取消收藏
     * @param dto
     * @return
     */
    public ResponseResult cancelCollectionMaterial(WmMaterialDto dto);
}
