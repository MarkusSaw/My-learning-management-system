package my.learning.management.system.service;


import my.learning.management.system.dto.CourseResponse;
import java.util.List;


public interface CourseService {
    List<CourseResponse> findAllCourses();
    CourseResponse findCourseById(Long id);
    CourseResponse createCourse(CourseResponse courseResponse);
    CourseResponse updateCourse(Long id, CourseResponse courseResponse);
    void deleteCourse(Long id);
}