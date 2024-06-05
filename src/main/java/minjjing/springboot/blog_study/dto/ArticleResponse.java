package minjjing.springboot.blog_study.dto;

import lombok.Getter;
import minjjing.springboot.blog_study.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
