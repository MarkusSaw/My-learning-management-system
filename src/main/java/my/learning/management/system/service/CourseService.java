package my.learning.management.system.service;


import my.learning.management.system.dto.CourseResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface CourseService {
    List<CourseResponse> findAllCourses();
    CourseResponse findCourseById(Long id);
    CourseResponse createCourse(CourseResponse courseResponse);
    CourseResponse updateCourse(Long id, CourseResponse courseResponse);
    void deleteCourse(Long id);
}