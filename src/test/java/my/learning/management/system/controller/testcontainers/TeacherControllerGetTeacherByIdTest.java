package my.learning.management.system.controller.testcontainers;

import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Objects;

public class TeacherControllerGetTeacherByIdTest extends AbstractIntegrationTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setName("Карабас");
        teacher.setLastname("Барабас");
        Teacher saved = teacherRepository.save(teacher);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/v1/teachers/" + saved.getId(), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("Карабас"));
    }
}


