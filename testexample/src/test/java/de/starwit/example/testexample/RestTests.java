package de.starwit.example.testexample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class RestTests {
    
    @Autowired
    private WebApplicationContext applicationContext;    

	@Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper mapper;
    
    @Autowired
    private MyUserRepository repository;

    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
        for (int i = 1; i<=10; i++) {
            MyUser u = new MyUser();
            u.setName("Test-" + i);
            u.setEmail("test-"+i+"@testmail.de");
            repository.save(u);
        }        
    }    

    @Test
    public void listingUsers() throws Exception {
        MockHttpServletResponse response = mvc
            .perform(get("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        String content = response.getContentAsString();
        System.out.println(content);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void findbyId() throws Exception {

        MyUser u = new MyUser();
        u.setName("Test");
        u.setEmail("test@testmail.de");
        repository.save(u);

        MockHttpServletResponse response = mvc
            .perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        String content = response.getContentAsString();
        System.out.println(content);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());       
    }

    @Test
    public void findbyNotId() throws Exception {
        MockHttpServletResponse response = mvc
            .perform(get("/api/user/100")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());       
    }    
}
