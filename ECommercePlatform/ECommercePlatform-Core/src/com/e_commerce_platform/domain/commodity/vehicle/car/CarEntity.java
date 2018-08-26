package com.e_commerce_platform.domain.commodity.vehicle.car;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.e_commerce_platform.domain.commodity.vehicle.VehicleEntity;

@Entity
public class CarEntity extends VehicleEntity{

	enum Transmission {
		AUTOMATIC,
		MANUAL;
	}

	
	private byte seatsNumber;
	@ManyToOne
	private FuelTypeEntity fuelType;
	@ManyToOne
	private BodyTypeEntity bodyType;
	@ManyToMany
	private Set<CarEquipmentEntity> seftyCarEquipmentType;
	@ManyToOne
	private CarModel carModel;
	@ManyToOne
	private DriveType driveType;
	private Transmission transmission;
	
}
