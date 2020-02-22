package com.mark.model.behavior.dtos;


import com.mark.model.annotation.IdEncrypt;
import com.mark.model.article.pojos.ApArticle;
import lombok.Data;

import java.util.List;

/**
 * @author MAIBENBEN
 */
@Data
public class ShowBehaviorDto {

    /**
     * 设备ID
     */
    @IdEncrypt
    Integer equipmentId;
    /**
     * 文章ID
     */
    List<ApArticle> articleIds;

}
