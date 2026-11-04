package my.learning.management.system.controller.testcontainers;

import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeacherControllerUpdateTest extends AbstractIntegrationTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldUpdateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("Карабас");
        teacher.setLastname("Барабас");
        Teacher saved = teacherRepository.save(teacher);

        String json = """ 
                {
                "name":"Александр",
                "lastname":"Барадач"
                }""";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        ResponseEntity<String> response = restTemplate.exchange("/api/v1/teachers/" + saved.getId(), HttpMethod.PUT, new HttpEntity<>(json, headers), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("Александр"));
        assertTrue(Objects.requireNonNull(response.getBody()).contains("Барадач"));
    }
}
