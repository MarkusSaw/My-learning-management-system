package my.learning.management.system.mapper;


import my.learning.management.system.dto.CourseResponse;
import my.learning.management.system.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponse toResponse(Course entity);
    List<CourseResponse> toResponseList(List<Course> entities);

    Course toCourse(CourseResponse response);
}
