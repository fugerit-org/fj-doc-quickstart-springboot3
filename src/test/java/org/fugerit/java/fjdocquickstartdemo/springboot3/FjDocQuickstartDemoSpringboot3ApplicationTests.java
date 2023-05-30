package org.fugerit.java.fjdocquickstartdemo.springboot3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = FjDocQuickstartDemoSpringboot3Application.class)
@AutoConfigureMockMvc
class FjDocQuickstartDemoSpringboot3ApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	@Test
	void testPdf() throws Exception {
		mvc.perform(get("http://localhost:8080/pdftest")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}
