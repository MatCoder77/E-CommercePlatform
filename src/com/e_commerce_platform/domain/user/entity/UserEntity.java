package com.e_commerce_platform.domain.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.e_commerce_platform.domain.location.entity.LocationEntity;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "adress")
	private LocationEntity address;
	
	public UserEntity() {}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public LocationEntity getAdress() {
		return address;
	}
	
	public UserEntity(UserEntityBuilder builder) {
		username = builder.username;
		firstName = builder.firstName;
		lastName = builder.lastName;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
		address = builder.address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
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
		
		public UserEntity build() {
			return new UserEntity(this);
		}
	}

	public int getId() {
		return id;
	}
}
