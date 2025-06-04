package org.ynovschool.myBlog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ynovschool.myBlog.dto.CategoryDTO;
import org.ynovschool.myBlog.mapper.CategoryMapper;
import org.ynovschool.myBlog.model.Category;
import org.ynovschool.myBlog.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testGetAllCategories() {
        // Arrange
        Category category1 = new Category();
        category1.setName("Category 1");

        Category category2 = new Category();
        category2.setName("Category 2");

        CategoryDTO dto1 = createCategoryDTO("Category 1");
        CategoryDTO dto2 = createCategoryDTO("Category 2");

        when(categoryRepository.findAll()).thenReturn(List.of(category1, category2));
        when(categoryMapper.convertToDTO(category1)).thenReturn(dto1);
        when(categoryMapper.convertToDTO(category2)).thenReturn(dto2);

        // Act
        List<CategoryDTO> categories = categoryService.getAllCategories();

        // Assert
        assertThat(categories).hasSize(2);
        assertThat(categories.get(0).getName()).isEqualTo("Category 1");
        assertThat(categories.get(1).getName()).isEqualTo("Category 2");
    }

    private CategoryDTO createCategoryDTO(String name) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(name);
        return dto;
    }

    @Test
    void testGetCategoryById_CategoryExists() {

        // Arrange
        Category category = new Category();
        category.setName("Category 1");

        // Mapping du Category en CategoryDTO
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.convertToDTO(category)).thenReturn(categoryDTO);

        // Act
        CategoryDTO result = categoryService.getCategoryById(1L);

        // Assert
        assertThat(result).isNotNull(); // Vérifie que l'objet n'est pas null
        assertThat(result.getName()).isEqualTo("Category 1");
    }

    @Test
    void testGetCategoryById_CategoryNotFound() {
        // Arrange
        when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> categoryService.getCategoryById(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Category not found");
    }
}