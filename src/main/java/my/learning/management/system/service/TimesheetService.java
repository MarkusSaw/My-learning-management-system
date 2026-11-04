package my.learning.management.system.service;

import my.learning.management.system.dto.TimesheetRequest;
import my.learning.management.system.dto.TimesheetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TimesheetService {
    Page<TimesheetResponse> findAllTimesheets(Pageable pageable);
    TimesheetResponse findTimesheetById(Long id);
    TimesheetResponse create(TimesheetRequest request);
    TimesheetResponse update(Long id, TimesheetRequest request);
    void delete(Long id);
    Page<TimesheetResponse> findByGroupId(Long groupId, Pageable pageable);
    Page<TimesheetResponse> findByTeacherId(Long teacherId, Pageable pageable);
}