package com.e_commerce_platform.api;


public class UserDTO {
	
	private long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocationDTO address;
	private AccountDataDTO accountData;

	public long getId() {
		return id;
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
	
	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public LocationDTO getAddress() {
		return address;
	}
	
	public AccountDataDTO getAccountData() {
		return accountData;
	}
	
	private UserDTO() {}
	
	private UserDTO(UserDTOBuilder builder) {
		id = builder.id;
		username = builder.username;
		firstName = builder.firstName;
		lastName = builder.lastName;
		phoneNumber = builder.phoneNumber;
		email = builder.email;
		address = builder.address;
		accountData = builder.accountData;
	}
	
	public static UserDTOBuilder builder() {
		return new UserDTOBuilder();
	}
	
	public static class UserDTOBuilder {
		
		private long id;
		private String username;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private LocationDTO address;
		private AccountDataDTO accountData;
		
		public UserDTOBuilder withId(long id) {
			this.id = id;
			return this;
		}
		
		public UserDTOBuilder withUsername(String username) {
			this.username = username;
			return this;
		}
		
		public UserDTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public UserDTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public UserDTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public UserDTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public UserDTOBuilder withAddress(LocationDTO address) {
			this.address = address;
			return this;
		}
		
		public UserDTOBuilder withAccountData(AccountDataDTO accountData) {
			this.accountData = accountData;
			return this;
		}
		
		public UserDTO build() {
			return new UserDTO(this);
		}
		
	}
	
}
