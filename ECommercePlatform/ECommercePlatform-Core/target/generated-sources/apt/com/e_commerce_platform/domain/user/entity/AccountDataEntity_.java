package com.e_commerce_platform.domain.user.entity;

import com.e_commerce_platform.domain.user.entity.AccountDataEntity.AccountType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountDataEntity.class)
public abstract class AccountDataEntity_ {

	public static volatile SingularAttribute<AccountDataEntity, AccountType> accountType;
	public static volatile SingularAttribute<AccountDataEntity, Long> id;
	public static volatile SingularAttribute<AccountDataEntity, LocalDateTime> creationDate;
	public static volatile SingularAttribute<AccountDataEntity, String> passwordSalt;
	public static volatile SingularAttribute<AccountDataEntity, String> passwordHash;

	public static final String ACCOUNT_TYPE = "accountType";
	public static final String ID = "id";
	public static final String CREATION_DATE = "creationDate";
	public static final String PASSWORD_SALT = "passwordSalt";
	public static final String PASSWORD_HASH = "passwordHash";

}

