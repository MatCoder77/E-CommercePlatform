package com.e_commerce_platform.domain.user.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.e_commerce_platform.domain.user.control.UserRepository;
import com.e_commerce_platform.domain.user.entity.UserEntity;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path(UserResource.MAIN_PATH)
public class UserResource {
	
	public static final String MAIN_PATH = "/user";
	private static final String ID = "id";
	private static final String ID_PATH = "/{" + ID + "}";
	
	@Inject
	UserRepository userRepository;
	
	@Inject
	UserMapper userMapper;
	
	@Path(ID_PATH)
	@GET
	public UserDTO getUser(@PathParam(ID) int id) {
		UserEntity foundUser = userRepository.getUserById(id);
		return userMapper.mapToDTO(foundUser);
	}
	
	@POST
	public Response createUser(UserDTO user) {
		UserEntity userEntity = userMapper.mapToEntity(user);
		String id = String.valueOf(userRepository.save(userEntity));
		return Response.ok()
				.entity(id)
				.build();
	}
}
