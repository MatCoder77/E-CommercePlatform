package com.e_commerce_platform.domain.commodity.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.e_commerce_platform.domain.commodity.CountryEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehicleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private short productionYear;
	private int mileage;
	private int engineSize;
	
	@ManyToOne
	private CountryEntity originCountry;
	
}
