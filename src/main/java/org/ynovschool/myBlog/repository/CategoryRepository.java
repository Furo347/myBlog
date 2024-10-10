package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
