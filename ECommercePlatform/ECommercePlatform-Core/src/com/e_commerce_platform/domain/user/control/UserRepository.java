package com.e_commerce_platform.domain.user.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;

import com.e_commerce_platform.domain.user.entity.UserEntity;
import com.e_commerce_platform.domain.user.entity.UserEntity_;

public class UserRepository {

	@PersistenceContext(unitName = "E-CommercePlatform")
	private EntityManager entityManager;

	public UserEntity getUserById(int id) {
		return entityManager.find(UserEntity.class, id);
	}

	public List<UserEntity> getUsersByIds(List<Integer> idList) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		Predicate inSetPredicate = root.get(UserEntity_.id).in(idList);
		criteriaQuery.where(inSetPredicate);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<UserEntity> getUsersByQueryParams(MultivaluedMap<String, String> queryParameters) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		List<Predicate> conditions = new ArrayList<>();
		for(Entry<String, List<String>> parameter : queryParameters.entrySet()) {
			Predicate inPredicate = root.get(parameter.getKey()).in(parameter.getValue());
			conditions.add(inPredicate);
		}
		criteriaQuery.where(conditions.toArray(new Predicate[0]));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	public long save(UserEntity userEntity) {
		entityManager.persist(userEntity);
		return userEntity.getId();
	}
	
	public void validateUser(UserEntity userEntity) {
		
	} 
	
	private boolean isUsernameUnique(String username) {
		return true;
	}
}
