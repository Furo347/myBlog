package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.ArticleAuthor;

public interface ArticleAuthorRepository extends JpaRepository<ArticleAuthor, Long> {
}
