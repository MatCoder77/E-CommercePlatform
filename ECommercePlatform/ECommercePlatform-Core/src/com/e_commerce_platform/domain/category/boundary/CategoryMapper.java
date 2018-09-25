package com.e_commerce_platform.domain.category.boundary;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.e_commerce_platform.api.CategoryDTO;
import com.e_commerce_platform.api.CategoryDTO.CategoryDTOBuilder;
import com.e_commerce_platform.domain.category.control.CategoryRepository;
import com.e_commerce_platform.domain.category.entity.CategoryEntity;
import com.e_commerce_platform.domain.category.entity.CategoryEntity.CategoryEntityBuilder;

import javafx.scene.Parent;

public class CategoryMapper {
	
	@Inject
	private CategoryRepository repostiory;
	
	public CategoryEntity mapToEntity(CategoryDTO categoryDTO) {
		return CategoryEntity.builder()
				.withId(categoryDTO.getId())
				.withName(categoryDTO.getName())
				.withParent(repostiory.getCategoryById(categoryDTO.getParentCategoryId()))
				.withSubcategories(mapToEntity(categoryDTO.getSubcategories()))
				.withIconName(categoryDTO.getIconName())
				.build();			
	}
	
	private Set<CategoryEntity> mapToEntity(Set<CategoryDTO> categoryDTOSet) {
		return categoryDTOSet.stream()
				.map(this::mapToEntity)
				.collect(Collectors.toSet());
	}
	
	public CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
		CategoryDTOBuilder builder = CategoryDTO.builder();
		categoryEntity.getParentCategory()
				.ifPresent(parent -> builder.withParentCategory(parent.getId()));
		return builder
				.withId(categoryEntity.getId())
				.withName(categoryEntity.getName())
				.withSubcategories(mapToDTO(categoryEntity.getSubcategories()))
				.withIconName(categoryEntity.getIconName())
				.build();
	}
	
	private Set<CategoryDTO> mapToDTO(Set<CategoryEntity> categoryEntitySet) {
		return categoryEntitySet.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toSet());
	}
}
