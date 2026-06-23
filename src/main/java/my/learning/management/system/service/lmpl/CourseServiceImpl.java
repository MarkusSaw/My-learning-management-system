package my.learning.management.system.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.learning.management.system.dao.CourseRepository;
import my.learning.management.system.dto.CourseResponse;
import my.learning.management.system.mapper.CourseMapper;
import my.learning.management.system.model.Course;
import my.learning.management.system.service.CourseService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    public List<CourseResponse> findAllCourses() {
        List<Course> courses = repository.findAll();
        return mapper.toResponseList(courses);
    }

    @Override
    public CourseResponse findCourseById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public CourseResponse createCourse(CourseResponse courseResponse) {
        Course course = mapper.toCourse(courseResponse);
        return mapper.toResponse(repository.save(course));
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseResponse courseResponse) {
        Course course = mapper.toCourse(courseResponse);
        course.setId(id);
        return mapper.toResponse(repository.save(course));
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}