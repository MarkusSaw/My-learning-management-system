package my.learning.management.system.mapper;

import my.learning.management.system.dto.TimesheetResponse;
import my.learning.management.system.model.Timesheet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimesheetMapper {
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.name", target = "courseName")
    @Mapping(source = "group.id", target = "groupId")
    @Mapping(source = "group.title", target = "groupTitle")
    @Mapping(source = "teacher.id", target = "teacherId")
    @Mapping(source = "teacher.name", target = "teacherName")
    TimesheetResponse toResponse(Timesheet entity);

    List<TimesheetResponse> toResponseList(List<Timesheet> entities);
}