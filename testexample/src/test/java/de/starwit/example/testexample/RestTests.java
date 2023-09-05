package de.starwit.example.testexample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = LoggerFactory.getLogger(RestTests.class);
    
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
    @Order(1)
    public void createUser() throws Exception {
        MyUser u = new MyUser();
        u.setEmail("test@mail.de");
        u.setName("Name from Test 1");

        String json = mapper.writeValueAsString(u);
        log.info("Serialized object " + json);
        MockHttpServletResponse response = mvc
            .perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andReturn()
            .getResponse();
        log.info("Status from Test 1 " + response.getStatus());
        log.info(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        response = mvc
            .perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        log.info(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @Order(2)
    public void listingUsers() throws Exception {
        MockHttpServletResponse response = mvc
            .perform(get("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        String content = response.getContentAsString();
        log.info("Response from Test 2");
        log.info(content);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @Order(3)
    public void findbyId() throws Exception {

        MockHttpServletResponse response = mvc
            .perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        String content = response.getContentAsString();
        log.info(content);
        log.info("Status from Test 3 " + response.getStatus());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());       
    }

    @Test
    @Order(4)
    public void findbyNotId() throws Exception {
        MockHttpServletResponse response = mvc
            .perform(get("/api/user/100")
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());       
    }
    
    @Test
    @Order(5)
    public void testBrokenMail() {
        /* 
            create broken object
            save, parse if response is rejective
        */
    }

    @Test
    @Order(6)
    public void testBulkImport() {
        /*
         * create list, import
         * check if number of stored objects maps
         * maybe you have to get number of already stored objects first...
         */
    }

}
