package com.e_commerce_platform.domain.category.entity;

import java.util.Set;
import java.util.Collections;
import java.util.Optional;

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
	
	private CategoryEntity(CategoryEntityBuilder builder) {
		id = builder.id;
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
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Optional<CategoryEntity> getParentCategory() {
		return Optional.ofNullable(parentCategory);
	}
	
	public Set<CategoryEntity> getSubcategories() {
		return Collections.unmodifiableSet(subcategories);
	}
	
	public static CategoryEntityBuilder builder() {
		return new CategoryEntityBuilder();
	}
	
	public static class CategoryEntityBuilder {
		private int id;
		private String name;
		private CategoryEntity parentCategory;
		private Set<CategoryEntity> subcategories;
		
		public CategoryEntityBuilder withId(int id) {
			this.id = id;
			return this;
		}
		
		public CategoryEntityBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public CategoryEntityBuilder withParent(CategoryEntity parent) {
			this.parentCategory = parent;
			return this;
		}
		
		public CategoryEntityBuilder withSubcategories(Set<CategoryEntity> subcategories) {
			this.subcategories = subcategories;
			return this;
		}
		
		public CategoryEntity build() {
			return new CategoryEntity(this);
		}
		
	}
	
}
