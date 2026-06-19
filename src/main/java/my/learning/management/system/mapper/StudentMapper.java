package my.learning.management.system.mapper;



import my.learning.management.system.dto.StudentResponse;
import my.learning.management.system.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponse toResponse(Student entity);
    List<StudentResponse> toResponseList(List<Student> entities);

    Student toStudent(StudentResponse response);
}
