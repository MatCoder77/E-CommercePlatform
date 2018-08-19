package com.e_commerce_platform.domain.location.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LocationEntity.class)
public abstract class LocationEntity_ {

	public static volatile SingularAttribute<LocationEntity, String> city;
	public static volatile SingularAttribute<LocationEntity, String> street;
	public static volatile SingularAttribute<LocationEntity, Integer> flatNumber;
	public static volatile SingularAttribute<LocationEntity, Integer> houseNumber;
	public static volatile SingularAttribute<LocationEntity, String> voivodeship;
	public static volatile SingularAttribute<LocationEntity, Integer> id;

	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String FLAT_NUMBER = "flatNumber";
	public static final String HOUSE_NUMBER = "houseNumber";
	public static final String VOIVODESHIP = "voivodeship";
	public static final String ID = "id";

}

