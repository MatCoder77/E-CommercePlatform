package com.e_commerce_platform.domain.category.boundary;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.e_commerce_platform.api.CategoryDTO;
import com.e_commerce_platform.domain.category.control.CategoryRepository;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path(CategoryResource.MAIN_PATH)
public class CategoryResource {
	public static final String MAIN_PATH = "category";
	
	@Inject
	CategoryRepository categoryRepository;
	
	@Inject
	CategoryMapper categoryMapper;
	
	@GET
	public List<CategoryDTO> getMainCategories() {
		return categoryRepository.getMainCategories()
				.stream()
				.map(categoryMapper::mapToDTO)
				.collect(Collectors.toList());
	}
	
}
