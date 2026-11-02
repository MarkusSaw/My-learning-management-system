package my.learning.management.system.controller.testcontainers;

import my.learning.management.system.dto.TeacherResponse;
import my.learning.management.system.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    void shouldCreateTeacher(){
        TeacherResponse request = new TeacherResponse();
        request.setName("Карабас");
        request.setLastname("Барабас");

        TeacherResponse response = teacherService.create(request);

        assertNotNull(response.getId());
        assertEquals("Карабас", response.getName());
        assertEquals("Барабас", response.getLastname());
    }
}
