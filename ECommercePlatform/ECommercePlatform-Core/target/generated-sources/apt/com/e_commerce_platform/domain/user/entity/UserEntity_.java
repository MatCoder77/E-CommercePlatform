package com.e_commerce_platform.domain.user.entity;

import com.e_commerce_platform.domain.location.entity.LocationEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> firstName;
	public static volatile SingularAttribute<UserEntity, String> lastName;
	public static volatile SingularAttribute<UserEntity, String> phoneNumber;
	public static volatile SingularAttribute<UserEntity, LocationEntity> address;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile SingularAttribute<UserEntity, AccountDataEntity> accountData;
	public static volatile SingularAttribute<UserEntity, String> username;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String ADDRESS = "address";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String ACCOUNT_DATA = "accountData";
	public static final String USERNAME = "username";

}

