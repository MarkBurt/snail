package com.mark.model.mess.admin;


import com.mark.model.article.pojos.ApArticleConfig;
import com.mark.model.article.pojos.ApArticleContent;
import com.mark.model.article.pojos.ApAuthor;
import lombok.Data;

@Data
public class AutoReviewClNewsSuccess {
    private ApArticleConfig apArticleConfig;
    private ApArticleContent apArticleContent;
    private ApAuthor apAuthor;

}
