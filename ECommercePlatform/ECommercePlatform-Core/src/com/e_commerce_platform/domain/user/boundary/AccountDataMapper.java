package com.e_commerce_platform.domain.user.boundary;

import com.e_commerce_platform.api.AccountDataDTO;
import com.e_commerce_platform.domain.user.entity.AccountDataEntity;

public class AccountDataMapper {
	
	public AccountDataEntity mapToEntity(AccountDataDTO accountDataDTO) {
		return AccountDataEntity.builder()
				.withPasswordSalt(accountDataDTO.getPasswordSalt())
				.withPasswordHash(accountDataDTO.getPasswordHash())
				.withAccountType(accountDataDTO.getAccountType())
				.build();
	}
	
	public AccountDataDTO mapToDTO(AccountDataEntity accountDataEntity) {
		return AccountDataDTO.builder()
				.withId(accountDataEntity.getId())
				.withPasswordSalt(accountDataEntity.getPasswordSalt())
				.withPasswordHash(accountDataEntity.getPasswordHash())
				.withAccountType(accountDataEntity.getAccountType().toString())
				.withCretionDate(accountDataEntity.getCreationDate())
				.build();
	}
}
