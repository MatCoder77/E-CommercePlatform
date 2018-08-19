package com.e_commerce_platform.domain.category.entity;

import java.util.Set;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne
	private CategoryEntity parentCategory;
	@OneToMany
	private Set<CategoryEntity> subcategories;
	
	CategoryEntity() {}
	
	private CategoryEntity(CategoryBuilder builder) {
		name = builder.name;
		parentCategory = builder.parentCategory;
		subcategories = builder.subcategories;
		subcategories.forEach(this::registerParentCategory);
	}
	
	private void registerParentCategory (CategoryEntity subcategory) {
		subcategory.parentCategory = this;
	}
	
	boolean isSubcategory() {
		return parentCategory == null;
	}
	
	int getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	public CategoryEntity getParentCategory() {
		return parentCategory;
	}
	
	public Set<CategoryEntity> getSubCategories() {
		return Collections.unmodifiableSet(subcategories);
	}
	
	public static class CategoryBuilder {
		private String name;
		private CategoryEntity parentCategory;
		private Set<CategoryEntity> subcategories;
		
		public CategoryBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public CategoryBuilder withParent(CategoryEntity parent) {
			this.parentCategory = parent;
			return this;
		}
		
		public CategoryBuilder withSubcategories(Set<CategoryEntity> subcategories) {
			this.subcategories = subcategories;
			return this;
		}
		
		public CategoryEntity build() {
			return new CategoryEntity(this);
		}
		
	}
	
}
