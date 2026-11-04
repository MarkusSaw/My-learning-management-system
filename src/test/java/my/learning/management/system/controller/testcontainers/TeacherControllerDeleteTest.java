package my.learning.management.system.controller.testcontainers;

import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TeacherControllerDeleteTest extends AbstractIntegrationTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldDeleteTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("Карабас");
        teacher.setLastname("Барабас");
        Teacher saved = teacherRepository.save(teacher);

        ResponseEntity<String> response = restTemplate.exchange("/api/v1/teachers/" + saved.getId(), HttpMethod.DELETE, new HttpEntity<>(teacher), String.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertFalse(teacherRepository.existsById(saved.getId()));
    }
}
