package com.e_commerce_platform.domain.user.boundary;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.e_commerce_platform.api.UserDTO;
import com.e_commerce_platform.domain.user.control.UserRepository;
import com.e_commerce_platform.domain.user.entity.UserEntity;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path(UserResource.MAIN_PATH)
public class UserResource {
	
	public static final String MAIN_PATH = "/user";
	private static final String ID = "id";
	private static final String ID_PATH = "/{" + ID + ":.*}";
	private static final String LIST_PATH = "/list";
	private static final String ID_LIST_DELIMITER = ",";
	private static final Pattern SPLIT_IDS_PATTERN = Pattern.compile(ID_LIST_DELIMITER);
	
	@Inject
	UserRepository userRepository;
	
	@Inject
	UserMapper userMapper;
	
	@Context
	UriInfo uriInfo;
	
	@Path(LIST_PATH + ID_PATH)
	@GET
	public List<UserDTO> getUsersByIds(@DefaultValue("") @PathParam(ID) String ids) {
		List<Integer> idList = Stream.of(SPLIT_IDS_PATTERN.split(ids))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		return userRepository.getUsersByIds(idList)
				.stream()
				.map(userMapper::mapToDTO)
				.collect(Collectors.toList());
	}
	
	@GET
	public List<UserDTO> getUsersByQueryParams() {
		return userRepository.getUsersByQueryParams(uriInfo.getQueryParameters())
				.stream()
				.map(userMapper::mapToDTO)
				.collect(Collectors.toList());
	}
	
/*	@Path(ID_PATH)
	@GET
	public UserDTO getUser(@PathParam(ID) int id) {
		UserEntity foundUser = userRepository.getUserById(id);
		return userMapper.mapToDTO(foundUser);
	}
*/	
	@POST
	public Response createUser(UserDTO user) {
		UserEntity userEntity = userMapper.mapToEntity(user);
		String id = String.valueOf(userRepository.save(userEntity));
		return Response.ok()
				.entity(id)
				.build();
	}
}
