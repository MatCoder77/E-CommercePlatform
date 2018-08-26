package com.e_commerce_platform.domain.commodity.vehicle.car;

import com.e_commerce_platform.domain.commodity.vehicle.car.CarEntity.Transmission;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarEntity.class)
public abstract class CarEntity_ extends com.e_commerce_platform.domain.commodity.vehicle.VehicleEntity_ {

	public static volatile SingularAttribute<CarEntity, BodyTypeEntity> bodyType;
	public static volatile SingularAttribute<CarEntity, Byte> seatsNumber;
	public static volatile SingularAttribute<CarEntity, Transmission> transmission;
	public static volatile SingularAttribute<CarEntity, FuelTypeEntity> fuelType;
	public static volatile SingularAttribute<CarEntity, DriveType> driveType;
	public static volatile SetAttribute<CarEntity, CarEquipmentEntity> seftyCarEquipmentType;
	public static volatile SingularAttribute<CarEntity, CarModel> carModel;

	public static final String BODY_TYPE = "bodyType";
	public static final String SEATS_NUMBER = "seatsNumber";
	public static final String TRANSMISSION = "transmission";
	public static final String FUEL_TYPE = "fuelType";
	public static final String DRIVE_TYPE = "driveType";
	public static final String SEFTY_CAR_EQUIPMENT_TYPE = "seftyCarEquipmentType";
	public static final String CAR_MODEL = "carModel";

}

