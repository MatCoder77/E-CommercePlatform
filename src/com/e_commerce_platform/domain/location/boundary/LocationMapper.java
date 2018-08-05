package com.e_commerce_platform.domain.location.boundary;

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
		return LocationDTO.builder()
				.withVoivodeship(locationEntity.getVoivodeship())
				.withCity(locationEntity.getCity())
				.withStreet(locationEntity.getStreet())
				.withHouseNumber(locationEntity.getHouseNumber())
				.withFlatNumber(locationEntity.getFlatNumber())
				.build();
	}
}
