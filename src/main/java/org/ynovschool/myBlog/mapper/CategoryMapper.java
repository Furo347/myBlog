package org.ynovschool.myBlog.mapper;

import org.springframework.stereotype.Component;
import org.ynovschool.myBlog.dto.ArticleDTO;
import org.ynovschool.myBlog.dto.CategoryDTO;
import org.ynovschool.myBlog.model.Article;
import org.ynovschool.myBlog.model.Category;
import org.ynovschool.myBlog.repository.CategoryRepository;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    private final CategoryRepository categoryRepository;

    public CategoryMapper (CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        if (category.getArticles() != null) {
            categoryDTO.setArticles(category.getArticles().stream().map(article -> {
                ArticleDTO articleDTO = new ArticleDTO();
                articleDTO.setId(article.getId());
                articleDTO.setTitle(article.getTitle());
                articleDTO.setContent(article.getContent());
                articleDTO.setCreatedAt(article.getCreatedAt());
                articleDTO.setUpdatedAt(article.getUpdatedAt());
                articleDTO.setCategoryId(article.getCategory().getId());
                return articleDTO;
            }).collect(Collectors.toList()));
        }
        return categoryDTO;
    }

    public Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        if (categoryDTO.getArticles() != null) {
            category.setArticles(categoryDTO.getArticles().stream().map(articleDTO -> {
                Article article = new Article();
                article.setId(articleDTO.getId());
                article.setTitle(articleDTO.getTitle());
                article.setContent(articleDTO.getContent());
                article.setCreatedAt(articleDTO.getCreatedAt());
                article.setUpdatedAt(articleDTO.getUpdatedAt());
                if (articleDTO.getCategoryId() != null) {
                    Category categoryRef = categoryRepository.findById(articleDTO.getCategoryId()).orElse(null);
                    article.setCategory(categoryRef);
                }
                return article;
            }).collect(Collectors.toList()));
        }
        return category;
    }
}