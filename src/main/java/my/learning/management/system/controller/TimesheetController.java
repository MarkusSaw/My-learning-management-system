package my.learning.management.system.controller;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dto.TimesheetRequest;
import my.learning.management.system.dto.TimesheetResponse;
import my.learning.management.system.service.TimesheetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/timesheets")
@RequiredArgsConstructor
public class TimesheetController {
    private final TimesheetService timesheetService;

    @GetMapping
    public Page<TimesheetResponse> getAllTimesheets(Pageable pageable) {
        return timesheetService.findAllTimesheets(pageable);
    }

    @GetMapping("/{id}")
    public TimesheetResponse getTimesheetById(@PathVariable Long id) {
        return timesheetService.findTimesheetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimesheetResponse create(@RequestBody TimesheetRequest timesheetRequest) {
        return timesheetService.create(timesheetRequest);
    }

    @PutMapping("/{id}")
    public TimesheetResponse update(@PathVariable Long id, @RequestBody TimesheetRequest timesheetRequest) {
        return timesheetService.update(id, timesheetRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        timesheetService.delete(id);
    }

    @GetMapping("/group/{groupId}")
    public Page<TimesheetResponse> getByGroupId(@PathVariable Long groupId, Pageable pageable) {
        return timesheetService.findByGroupId(groupId, pageable);
    }

    @GetMapping("/teacher/{teacherId}")
    public Page<TimesheetResponse> getByTeacherId(@PathVariable Long teacherId, Pageable pageable) {
        return timesheetService.findByTeacherId(teacherId, pageable);
    }


}



