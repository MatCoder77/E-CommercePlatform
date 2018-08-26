package com.e_commerce_platform.domain.category.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.e_commerce_platform.domain.category.entity.CategoryEntity;
import com.e_commerce_platform.domain.category.entity.CategoryEntity_;

public class CategoryRepository {
	
	@PersistenceContext(unitName = "E-CommercePlatform")
	private EntityManager entityManager;

	public List<CategoryEntity> getMainCategories() {	
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CategoryEntity> criteriaQuery = criteriaBuilder.createQuery(CategoryEntity.class);
		Root<CategoryEntity> root = criteriaQuery.from(CategoryEntity.class);
		criteriaQuery.select(root);
		Predicate isMainCategoryConditon = root.get(CategoryEntity_.parentCategory).isNull();
		criteriaQuery.where(isMainCategoryConditon);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
