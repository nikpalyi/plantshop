package spring.plantshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class SpringBootWebApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ConfigurableEnvironment environment;

	@Test
	public void contextLoads() {
		this.environment.getProperty("spring.application.name");
	}

	@Test
	public void resource() throws Exception {
		this.mockMvc.perform(get("/products"))
				.andExpect(content().string(containsString("Product List")));
	}

}
