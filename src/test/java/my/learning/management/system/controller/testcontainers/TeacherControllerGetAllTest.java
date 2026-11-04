package my.learning.management.system.controller.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherControllerGetAllTest extends AbstractIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnTeacher() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/api/v1/teachers", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}