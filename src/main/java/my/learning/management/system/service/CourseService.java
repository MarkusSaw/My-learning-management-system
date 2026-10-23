package my.learning.management.system.service;


import my.learning.management.system.dto.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface CourseService {
    Page<CourseResponse> findAllCourses(Pageable pageable);
    CourseResponse findCourseById(Long id);
    CourseResponse create(CourseResponse courseResponse);
    CourseResponse update(Long id, CourseResponse courseResponse);
    void delete(Long id);
}