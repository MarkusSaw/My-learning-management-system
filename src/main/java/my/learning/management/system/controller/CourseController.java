package my.learning.management.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import my.learning.management.system.dto.CourseResponse;
import my.learning.management.system.service.CourseService;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(@RequestBody CourseResponse courseResponse) {
        return courseService.createCourse(courseResponse);
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable Long id,
                                       @RequestBody CourseResponse courseResponse) {
        return courseService.updateCourse(id, courseResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}