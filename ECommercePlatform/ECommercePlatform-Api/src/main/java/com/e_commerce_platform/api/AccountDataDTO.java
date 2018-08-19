package com.e_commerce_platform.api;

import java.time.LocalDateTime;

public class AccountDataDTO {
	
	private long id;
	private String passwordSalt;
	private String passwordHash;
	private String accountType;
	private LocalDateTime creationDate;
	
	private AccountDataDTO() {}
	
	private AccountDataDTO(AccountDataDTOBuilder builder) {
		id = builder.id;
		passwordSalt = builder.passwordSalt;
		passwordHash = builder.passwordHash;
		accountType = builder.accountType;
		creationDate = builder.creationDate;
	}
	
	public long getId() {
		return id;
	}
	
	public String getPasswordSalt() {
		return passwordSalt;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public static AccountDataDTOBuilder builder() {
		return new AccountDataDTOBuilder();
	}
	
	static public class AccountDataDTOBuilder {
		
		private long id;
		private String passwordSalt;
		private String passwordHash;
		private String accountType;
		private LocalDateTime creationDate;
		
		public AccountDataDTOBuilder withId(long id) {
			this.id = id;
			return this;
		}
		
		public AccountDataDTOBuilder withPasswordSalt(String passwordSalt) {
			this.passwordSalt = passwordSalt;
			return this;
		}
		
		public AccountDataDTOBuilder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}
		
		public AccountDataDTOBuilder withAccountType(String accountType) {
			this.accountType = accountType;
			return this;
		}
		
		public AccountDataDTOBuilder withCretionDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
			return this;
		}
		
		public AccountDataDTO build() {
			return new AccountDataDTO(this);
		}
		
	}
	
}
