package com.e_commerce_platform.domain.user.boundary;

import javax.inject.Inject;

import com.e_commerce_platform.domain.user.entity.UserEntity;
import com.e_commerce_platform.api.UserDTO;
import com.e_commerce_platform.domain.location.boundary.LocationMapper;

public class UserMapper {
	
	@Inject
	LocationMapper locationMapper;
	
	@Inject
	AccountDataMapper accountDataMapper;
	
	public UserEntity mapToEntity(UserDTO userDTO) {
		return UserEntity.builder()
				.withUsername(userDTO.getUsername())
				.withFirstName(userDTO.getFirstName())
				.withLastName(userDTO.getLastName())
				.withEmail(userDTO.getEmail())
				.withPhoneNumber(userDTO.getPhoneNumber())
				.withAddress(locationMapper.mapToEntity(userDTO.getAddress()))
				.withAccountData(accountDataMapper.mapToEntity(userDTO.getAccountData()))
				.build();
	}
	
	public UserDTO mapToDTO(UserEntity userEntity) {
		return UserDTO.builder()
				.withId(userEntity.getId())
				.withUsername(userEntity.getUsername())
				.withFirstName(userEntity.getFirstName())
				.withLastName(userEntity.getLastName())
				.withEmail(userEntity.getEmail())
				.withPhoneNumber(userEntity.getPhoneNumber())
				.withAddress(locationMapper.mapToDTO(userEntity.getAddress()))
				.withAccountData(accountDataMapper.mapToDTO(userEntity.getAccountData()))
				.build();
	}
	
}
