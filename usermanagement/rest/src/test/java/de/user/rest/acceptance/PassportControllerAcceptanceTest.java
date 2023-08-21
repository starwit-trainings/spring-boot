package de.user.rest.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import de.user.persistence.entity.PassportEntity;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc(addFilters = false)
public class PassportControllerAcceptanceTest extends AbstractControllerAcceptanceTest<PassportEntity> {


    final static Logger LOG = LoggerFactory.getLogger(PassportControllerAcceptanceTest.class);
    private static final String data = "testdata/passport/";
    private static final String restpath = "/api/passports/";

    private JacksonTester<PassportEntity> jsonTester;

    @Override
    public Class<PassportEntity> getEntityClass() {
        return PassportEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    @Override
    public JacksonTester<PassportEntity> getJsonTester() {
        return jsonTester;
    }

    @Test
    public void canCreate() throws Exception {
        // given
//        PassportEntity entity = readFromFile(data + "Passport.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        PassportEntity entityresult = mapper.readValue(response.getContentAsString(), PassportEntity.class);
//        assertThat(entityresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void isValidated() throws Exception {
        // given
//        PassportEntity entity = readFromFile(data + "Passport-wrong.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void canNotFindById() throws Exception {
        // when
        MockHttpServletResponse response = mvc
                .perform(get(getRestPath() + "/4242").contentType(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void canRetrieveById() throws Exception {
        // given
//        PassportEntity entity = readFromFile(data + "Passport.json");
//        MockHttpServletResponse response = create(entity);
//        PassportEntity entity2 = mapper.readValue(response.getContentAsString(), PassportEntity.class);

        // when
//        response = retrieveById(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        PassportEntity entityresult = mapper.readValue(response.getContentAsString(), PassportEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void canUpdate() throws Exception {

        // given
//        PassportEntity entity = readFromFile(data + "Passport.json");
//        MockHttpServletResponse response = create(entity);
//        PassportEntity entity2 = mapper.readValue(response.getContentAsString(), PassportEntity.class);

        // when
//        response = update(entity2);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        PassportEntity entityresult = mapper.readValue(response.getContentAsString(), PassportEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Override
    @Test
    public void canDelete() throws Exception {
        // given
//        PassportEntity entity = readFromFile(data + "Passport.json");
//        MockHttpServletResponse response = create(entity);
//        PassportEntity entity2 = mapper.readValue(response.getContentAsString(), PassportEntity.class);
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        // when
//        delete(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}
