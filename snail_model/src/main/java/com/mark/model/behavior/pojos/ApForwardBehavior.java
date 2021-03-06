package com.mark.model.behavior.pojos;

import com.mark.model.annotation.IdEncrypt;
import lombok.Data;

import java.util.Date;

/**
 * @author MAIBENBEN
 */
@Data
public class ApForwardBehavior {
    private Long id;
    @IdEncrypt
    private Integer entryId;
    private Integer articleId;
    private Integer dynamicId;
    private Date createdTime;
}