package com.e_commerce_platform.domain.location.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String voivodeship;
	private String city;
	private String street;
	private int houseNumber;
	private int flatNumber;
	
	public String getVoivodeship() {
		return voivodeship;
	}
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	
	public LocationEntity() {}
	
	private LocationEntity(LocationEntityBuilder builder) {
		voivodeship = builder.voivodeship;
		city = builder.city;
		street = builder.street;
		houseNumber = builder.houseNumber;
		flatNumber = builder.flatNumber;
	}
	
	public static LocationEntityBuilder builder() {
		return new LocationEntityBuilder();
	}
	
	public static class LocationEntityBuilder {
		
		private String voivodeship;
		private String city;
		private String street;
		private int houseNumber;
		private int flatNumber;
		
		public LocationEntityBuilder withVoivodeship(String voivodeship) {
			this.voivodeship = voivodeship;
			return this;
		}
		
		public LocationEntityBuilder withCity(String city) {
			this.city = city;
			return this;
		}
		
		public LocationEntityBuilder withStreet(String street) {
			this.street = street;
			return this;
		}
		
		public LocationEntityBuilder withHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}
		
		public LocationEntityBuilder withFlatNumber(int flatNumber) {
			this.flatNumber = flatNumber;
			return this;
		}
		
		public LocationEntity build() {
			return new LocationEntity(this);
		}
		
	}
	
}
