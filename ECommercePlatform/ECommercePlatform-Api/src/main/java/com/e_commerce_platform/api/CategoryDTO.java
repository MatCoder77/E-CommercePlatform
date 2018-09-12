package com.e_commerce_platform.api;

import java.util.Set;

public class CategoryDTO {
	
	private int id;
	private int parentCategoryId;
	private String name;
	private Set<CategoryDTO> subcategories;
	
	private CategoryDTO() {}
	
	private CategoryDTO(CategoryDTOBuilder builder) {
		id = builder.id;
		parentCategoryId = builder.parentCategoryId;
		name = builder.name;
		subcategories = builder.subcategories;
	}
	
	public int getId() {
		return id;
	}
	
	public int getParentCategory() {
		return parentCategoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<CategoryDTO> getSubcategories() {
		return subcategories;
	}
	
	public static CategoryDTOBuilder builder() {
		return new CategoryDTOBuilder();
	}
	
	public static class CategoryDTOBuilder {
		
		private int id;
		private int parentCategoryId;
		private String name;
		private Set<CategoryDTO> subcategories;
		
		public CategoryDTOBuilder withId(int id) {
			this.id = id;
			return this;
		}
		
		public CategoryDTOBuilder withParentCategory(int parentCategoryId) {
			this.parentCategoryId = parentCategoryId;
			return this;
		}
		
		public CategoryDTOBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public CategoryDTOBuilder withSubcategories(Set<CategoryDTO> subcategories) {
			this.subcategories = subcategories;
			return this;
		}
		
		public CategoryDTO build() {
			return new CategoryDTO(this);
		}
		
	}
	
}
