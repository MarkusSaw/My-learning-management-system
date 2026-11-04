package my.learning.management.system.controller.testcontainers;

import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherControllerTest extends AbstractIntegrationTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnAllTeachers() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/api/v1/teachers", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

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

    @Test
    void shouldCreateTeacher(){
        String json = """ 
               {
               "name":"Карабас",
               "lastname":"Барабас"
               }""";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/teachers" ,request,String.class);

        assertEquals(HttpStatus.CREATED , response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Карабас"));
    }

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
