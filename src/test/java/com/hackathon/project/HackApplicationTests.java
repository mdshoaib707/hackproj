package com.hackathon.project;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HackApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetEmployee() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/employee/1")
		        .accept(MediaType.TEXT_HTML)
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(content().string(
		                equalTo("{'response' : 'success'}")));
	}

	@Test
	public void testGetEmployeeList() throws Exception {

		mvc.perform(MockMvcRequestBuilders.post("/employee/list")
		        .accept(MediaType.TEXT_HTML)
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{}")).andExpect(status().isOk())
		        .andExpect(content().string(
		                equalTo("{'response' : 'success'}")));
	}

}
