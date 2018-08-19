package com.e_commerce_platform.domain.commodity.vehicle;

import com.e_commerce_platform.domain.commodity.CountryEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehicleEntity.class)
public abstract class VehicleEntity_ {

	public static volatile SingularAttribute<VehicleEntity, Integer> engineSize;
	public static volatile SingularAttribute<VehicleEntity, CountryEntity> originCountry;
	public static volatile SingularAttribute<VehicleEntity, Long> id;
	public static volatile SingularAttribute<VehicleEntity, Short> productionYear;
	public static volatile SingularAttribute<VehicleEntity, Integer> mileage;

	public static final String ENGINE_SIZE = "engineSize";
	public static final String ORIGIN_COUNTRY = "originCountry";
	public static final String ID = "id";
	public static final String PRODUCTION_YEAR = "productionYear";
	public static final String MILEAGE = "mileage";

}

