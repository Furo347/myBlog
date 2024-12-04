package org.ynovschool.myBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ynovschool.myBlog.model.Image;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
