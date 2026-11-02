package my.learning.management.system.mapper;



import my.learning.management.system.dto.StudentResponse;
import my.learning.management.system.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "group.title", target = "groupName")
    StudentResponse toResponse(Student entity);

    List<StudentResponse> toResponseList(List<Student> entities);

    @Mapping(target = "group", ignore = true)
    Student toStudent(StudentResponse response);
}
