package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
