package org.ynovschool.myBlog.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.ynovschool.myBlog.dto.CategoryDTO;
import org.ynovschool.myBlog.exception.ResourceNotFoundException;
import org.ynovschool.myBlog.service.CategoryService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void testGetAllCategories() throws Exception {
        // Arrange
        CategoryDTO category1 = new CategoryDTO();
        category1.setName("Category 1");

        CategoryDTO category2 = new CategoryDTO();
        category2.setName("Category 2");

        when(categoryService.getAllCategories()).thenReturn(List.of(category1, category2));

        // Act & Assert
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Category 1"))
                .andExpect(jsonPath("$[1].name").value("Category 2"));
    }

    @Test
    void testGetCategoryById_CategoryExists() throws Exception {
        // Arrange
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Category 1");

        when(categoryService.getCategoryById(1L)).thenReturn(categoryDTO);

        // Act & Assert
        mockMvc.perform(get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Category 1"));
    }


    @Test
    void testGetCategoryById_CategoryNotFound() throws Exception {
        // Arrange: Mock the service to throw ResourceNotFoundException
        when(categoryService.getCategoryById(99L)).thenThrow(new ResourceNotFoundException("Category not found"));

        // Act & Assert: Ensure the correct status and error message is returned
        mockMvc.perform(get("/api/categories/99"))
                .andExpect(status().isNotFound())  // Check for status 404
                .andExpect(content().string("Category not found"));  // Check for the exception message
    }

}