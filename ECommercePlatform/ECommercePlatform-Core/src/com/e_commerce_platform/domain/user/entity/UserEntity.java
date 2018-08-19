package com.e_commerce_platform.domain.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.e_commerce_platform.domain.location.entity.LocationEntity;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "adress")
	private LocationEntity address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDataEntity accountData;

	public UserEntity() {}
	
	public long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public LocationEntity getAddress() {
		return address;
	}
	
	public void setAddress(LocationEntity address) {
		this.address = address;
	}
	
	public AccountDataEntity getAccountData() {
		return accountData;
	}

	public void setAccountData(AccountDataEntity accountData) {
		this.accountData = accountData;
	}
	
	public UserEntity(UserEntityBuilder builder) {
		username = builder.username;
		firstName = builder.firstName;
		lastName = builder.lastName;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
		address = builder.address;
		accountData = builder.accountData;
	}
	
	public static UserEntityBuilder builder() {
		return new UserEntityBuilder();
	}
	
	public static class UserEntityBuilder {
		
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private LocationEntity address;
		private AccountDataEntity accountData;
		
		public UserEntityBuilder withUsername(String username) {
			this.username = username;
			return this;
		}
		
		public UserEntityBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public UserEntityBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public UserEntityBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public UserEntityBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public UserEntityBuilder withAddress(LocationEntity address) {
			this.address = address;
			return this;
		}
		
		public UserEntityBuilder withAccountData(AccountDataEntity accountData) {
			this.accountData = accountData;
			return this;
		}
		
		public UserEntity build() {
			return new UserEntity(this);
		}
		
	}

}
