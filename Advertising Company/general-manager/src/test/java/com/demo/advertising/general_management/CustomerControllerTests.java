package com.demo.advertising.general_management;

import com.demo.advertising.general_management.controllers.CustomerController;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
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

	@Test
	public void createCustomerTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.post("/Customer")
						.content(asJsonString(new Customer("1", "Name1", "email1@mail.com", "phone1", "card1")))
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Test
	public void getCustomerByCustomerIdTest() throws Exception{

		mvc.perform(MockMvcRequestBuilders
				.get("/Customer/{customerId}", "1")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void updateCustomerTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders
						.put("/Customer/{customerId}", "2")
						.content(asJsonString(new Customer("2","Name2", "email2@mail.com", "phone2", "card2")))
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Name2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("phone2"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.paymentDetails").value("card2"));
	}

	@Test
	public void deleteCustomerTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.delete("/Customer/{customerId}", "3"))
				.andExpect(status().isAccepted());
	}

}
