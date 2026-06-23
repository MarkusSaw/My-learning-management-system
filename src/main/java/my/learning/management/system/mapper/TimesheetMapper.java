package my.learning.management.system.mapper;


import my.learning.management.system.dto.CourseResponse;
import my.learning.management.system.dto.TimesheetResponse;
import my.learning.management.system.model.Course;
import my.learning.management.system.model.Timesheet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimesheetMapper {

    TimesheetResponse toResponse(Timesheet entity);
    List<TimesheetResponse> toResponseList(List<Timesheet> entities);

    Timesheet toTimesheet(TimesheetResponse response);
}
