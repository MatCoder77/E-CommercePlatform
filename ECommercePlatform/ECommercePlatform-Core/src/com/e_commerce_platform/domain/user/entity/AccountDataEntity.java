package com.e_commerce_platform.domain.user.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class AccountDataEntity {
	
	public enum AccountType {
		ADMINISTRATOR,
		MODERATOR,
		USER,
		GUEST
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String passwordSalt;
	private String passwordHash;
	private AccountType accountType;
	
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	public AccountDataEntity() {}
	
	private AccountDataEntity(AccountDataEntityBuilder builder) {
		passwordSalt = builder.passwordSalt;
		passwordHash = builder.passwordHash;
		accountType = AccountType.valueOf(builder.accountType);
	}
	

	public long getId() {
		return id;
	}
	
	public String getPasswordSalt() {
		return passwordSalt;
	}
	
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	@PrePersist
	void createdAt() {
		this.creationDate = LocalDateTime.now();
	}

	public static AccountDataEntityBuilder builder() {
		return new AccountDataEntityBuilder();
	}
	
	public static class AccountDataEntityBuilder {
			
		private String passwordSalt;
		private String passwordHash;
		private String accountType;
		
		public AccountDataEntityBuilder withPasswordSalt(String passwordSalt) {
			this.passwordSalt = passwordSalt;
			return this;
		}
		
		public AccountDataEntityBuilder withPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
			return this;
		}
		
		public AccountDataEntityBuilder withAccountType(String accountType) {
			this.accountType = accountType;
			return this;
		}
		
		public AccountDataEntity build() {
			return new AccountDataEntity(this);
		}
		
	}
	
}
