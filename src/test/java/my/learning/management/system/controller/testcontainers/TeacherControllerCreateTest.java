package my.learning.management.system.controller.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class TeacherControllerCreateTest extends AbstractIntegrationTest{

    @Autowired
    private TestRestTemplate restTemplate;

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
}
