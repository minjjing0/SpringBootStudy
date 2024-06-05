package minjjing.springboot.blog_study.repository;

import minjjing.springboot.blog_study.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogReposiroty extends JpaRepository<Article, Long> {
}
