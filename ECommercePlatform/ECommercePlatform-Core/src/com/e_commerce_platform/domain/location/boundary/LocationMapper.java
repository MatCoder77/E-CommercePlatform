package com.e_commerce_platform.domain.location.boundary;

import com.e_commerce_platform.api.LocationDTO;
import com.e_commerce_platform.api.LocationDTO.LocationDTOBuilder;
import com.e_commerce_platform.domain.location.entity.LocationEntity;

public class LocationMapper {

	public LocationEntity mapToEntity(LocationDTO locationDTO) {
		return LocationEntity.builder()
				.withVoivodeship(locationDTO.getVoivodeship())
				.withCity(locationDTO.getCity())
				.withStreet(locationDTO.getStreet())
				.withHouseNumber(locationDTO.getHouseNumber())
				.withFlatNumber(locationDTO.getFlatNumber())
				.build();
	}
	
	public LocationDTO mapToDTO(LocationEntity locationEntity) {
		LocationDTOBuilder builder = LocationDTO.builder();
		locationEntity.getStreet().ifPresent(builder::withCity);
		locationEntity.getHouseNumber().ifPresent(builder::withHouseNumber);
		locationEntity.getFlatNumber().ifPresent(builder::withFlatNumber);
		
		return builder.withVoivodeship(locationEntity.getVoivodeship())
				.withId(locationEntity.getId())
				.withCity(locationEntity.getCity())
				.build();
	}
}
