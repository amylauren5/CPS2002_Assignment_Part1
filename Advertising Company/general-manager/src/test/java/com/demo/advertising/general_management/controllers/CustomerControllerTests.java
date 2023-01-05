package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.CustomerController;
import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	CustomerService customerService;


	// METHOD FOR JSON CONVERSION
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// CUSTOMER CREATION TESTS

	@Test
	public void createCustomerWithCardAndSubscribeNoTest() throws Exception{

		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com",
								"phone1", new CardEntity("123456789", "06/08/2027",
								"567"), new PayPalEntity("string","string"), "no")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer.customerId").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMessage").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.notificationMessage").exists());
	}

	@Test
	public void createCustomerWithPayPalAndSubscribeNoTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com",
								"phone1", new CardEntity("string", "string", "string"),
								new PayPalEntity("user1", "pass123"), "no")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer.customerId").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMessage").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.notificationMessage").exists());
	}

	@Test
	public void createCustomerWithPayPalAndSubscribeYes() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com",
								"phone1", new CardEntity("string", "string", "string") ,
								new PayPalEntity("user1", "pass123"), "yes")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer.customerId").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMessage").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.notificationMessage").exists());
	}

	@Test
	public void createCustomerWithCardAndSubscribeYes() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com",
								"phone1", new CardEntity("123456789", "08/07/2027", "456") ,
								new PayPalEntity("string", "string"), "yes")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer.customerId").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMessage").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.notificationMessage").exists());
	}

	@Test
	public void createCustomerWithNoCardAndNoPayPalTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com",
								"phone1", new CardEntity("string", "string", "string"),
								new PayPalEntity("string","string"), "no")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customer.customerId").exists());
	}

	@Test
	public void getCustomerByCustomerIdTest() throws Exception{

		mvc.perform(MockMvcRequestBuilders
				.get("/Customer/{customerId}", "1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value("1"));
	}

	@Test
	public void updateCustomerTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders
						.put("/Customer/{customerId}", "2")
						.content(asJsonString(new Customer("2","Name2", "email2@mail.com", "phone2","no")))
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Name2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("phone2"));
	}

	@Test
	public void deleteCustomerTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.delete("/Customer/{customerId}", "3"))
				.andExpect(status().isAccepted());
	}

}