package ecommerceplatform.console.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import java.util.List;
import com.e_commerce_platform.api.CategoryDTO;

public class ServerClient {
	public List<CategoryDTO> getMainCategories() {
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080//ECommercePlatform-Core/category")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<CategoryDTO>>() {});
	}
}
