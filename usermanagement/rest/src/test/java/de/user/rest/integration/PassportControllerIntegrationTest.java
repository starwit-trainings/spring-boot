package de.user.rest.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import de.user.persistence.entity.PassportEntity;
import de.user.rest.controller.PassportController;
import de.user.service.impl.PassportService;

/**
 * Tests for PassportController
 *
 * <pre>
 * @WebMvcTest also auto-configures MockMvc which offers a powerful way of
 * easy testing MVC controllers without starting a full HTTP server.
 * </pre>
 */
@WebMvcTest(controllers = PassportController.class)
public class PassportControllerIntegrationTest extends AbstractControllerIntegrationTest<PassportEntity> {

    @MockBean
    private PassportService passportService;

    private JacksonTester<PassportEntity> jsonPassportEntity;
    private static final String data = "testdata/passport/";
    private static final String restpath = "/api/passports/";

    @Override
    public Class<PassportEntity> getEntityClass() {
        return PassportEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    //implement tests here
    @Test
    public void canRetrieveById() throws Exception {

//        PassportEntity entityToTest = readFromFile(data + "passport.json");
//        when(appService.findById(0L)).thenReturn(entityToTest);

//        MockHttpServletResponse response = retrieveById(0L);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonAppDto.write(dto).getJson());
    }

}
