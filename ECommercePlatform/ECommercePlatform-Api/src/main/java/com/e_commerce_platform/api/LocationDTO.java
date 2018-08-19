package com.e_commerce_platform.api;

public class LocationDTO {
	
	private long id;
	private String voivodeship;
	private String city;
	private String street;
	private int houseNumber;
	private int flatNumber;
	
	private LocationDTO() {}
	
	private LocationDTO(LocationDTOBuilder builder) {
		id = builder.id;
		voivodeship = builder.voivodeship;
		city = builder.city;
		street = builder.street;
		houseNumber = builder.houseNumber;
		flatNumber = builder.flatNumber;
	}
	
	public long getId() {
		return id;
	}

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
	
	public static LocationDTOBuilder builder() {
		return new LocationDTOBuilder();
	}

	public static class LocationDTOBuilder {
		
		private long id;
		private String voivodeship;
		private String city;
		private String street;
		private int houseNumber;
		private int flatNumber;
		
		public LocationDTOBuilder withId(long id) {
			this.id = id;
			return this;
		}
		
		public LocationDTOBuilder withVoivodeship(String voivodeship) {
			this.voivodeship = voivodeship;
			return this;
		}
		
		public LocationDTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}
		
		public LocationDTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}
		
		public LocationDTOBuilder withHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}
		
		public LocationDTOBuilder withFlatNumber(int flatNumber) {
			this.flatNumber = flatNumber;
			return this;
		}
		
		public LocationDTO build() {
			return new LocationDTO(this);
		}		
		
	}
	
}
