package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}