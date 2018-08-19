package com.e_commerce_platform.domain.category.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CategoryEntity.class)
public abstract class CategoryEntity_ {

	public static volatile SingularAttribute<CategoryEntity, String> name;
	public static volatile SingularAttribute<CategoryEntity, CategoryEntity> parentCategory;
	public static volatile SingularAttribute<CategoryEntity, Integer> id;
	public static volatile SetAttribute<CategoryEntity, CategoryEntity> subcategories;

	public static final String NAME = "name";
	public static final String PARENT_CATEGORY = "parentCategory";
	public static final String ID = "id";
	public static final String SUBCATEGORIES = "subcategories";

}

