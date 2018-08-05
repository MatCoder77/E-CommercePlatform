package com.e_commerce_platform.domain.user.control;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.e_commerce_platform.domain.user.entity.UserEntity;


public class UserRepository {
	
	@PersistenceContext(unitName = "E-CommercePlatform")
	private EntityManager entityManager;

	public UserEntity getUserById(int id) {
		return entityManager.find(UserEntity.class, id);
	}
	
	public int save(UserEntity userEntity) {
		entityManager.persist(userEntity);
		return userEntity.getId();
	}
}
