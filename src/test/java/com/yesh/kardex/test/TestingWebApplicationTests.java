package com.yesh.kardex.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yesh.kardex.controller.ClientController;
import com.yesh.kardex.controller.ProductController;
import com.yesh.kardex.service.ClientService;
import com.yesh.kardex.service.ProductService;


@SpringBootTest()
public class TestingWebApplicationTests {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductController productController;
	@Autowired
	private ClientController clientController;
	@Autowired
	static private WebApplicationContext webApplicationContext;
	
	static private MockMvc mockMvc;

	@BeforeAll
	static public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testProducts() throws Exception {
		mockMvc.perform(get("/products")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testClientsDB() {
		// La base de datos del ciente se prueba con 2 clientes
		assertEquals(2, clientService.getAllClients().size());
	}
	@Test
	public void testProductsDB() {
		// La base de datos de los productos se prueba con 5 productos
		assertEquals(5, productService.getAllProducts().size());
	}
	
	// Probar que los controladores retornan valores no nulos
	@Test
	public void testProductController() {
		assertThat(productController).isNotNull();
	}
	@Test
	public void testClientController() {
		assertThat(clientController).isNotNull();
	}

}

