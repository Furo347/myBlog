package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}