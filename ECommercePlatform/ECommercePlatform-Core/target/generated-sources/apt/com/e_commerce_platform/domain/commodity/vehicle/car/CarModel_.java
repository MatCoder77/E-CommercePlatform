package com.e_commerce_platform.domain.commodity.vehicle.car;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarModel.class)
public abstract class CarModel_ {

	public static volatile SingularAttribute<CarModel, String> name;
	public static volatile SingularAttribute<CarModel, Integer> id;
	public static volatile SingularAttribute<CarModel, CarMake> carMake;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String CAR_MAKE = "carMake";

}

