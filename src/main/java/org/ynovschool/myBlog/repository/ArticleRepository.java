package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Article;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);

    List<Article> findByContentContaining(String title);

    List<Article> findByCreatedAtAfter(LocalDateTime date);

    List<Article> findTop5ByOrderByCreatedAtDesc();
}
