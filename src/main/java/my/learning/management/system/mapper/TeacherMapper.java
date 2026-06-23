package my.learning.management.system.mapper;



import my.learning.management.system.dto.TeacherResponse;
import my.learning.management.system.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherResponse toResponse(Teacher entity);
    List<TeacherResponse> toResponseList(List<Teacher> entities);

    Teacher toTeacher(TeacherResponse response);
}
