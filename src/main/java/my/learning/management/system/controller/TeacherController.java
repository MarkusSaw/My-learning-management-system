package my.learning.management.system.controller;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dto.TeacherResponse;
import my.learning.management.system.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public Page<TeacherResponse> getAllTeachers(Pageable pageable) {
        return teacherService.findAllTeachers(pageable);
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse create(@RequestBody TeacherResponse teacherResponse) {
        return teacherService.create(teacherResponse);
    }

    @PutMapping("/{id}")
    public TeacherResponse update(@PathVariable Long id, @RequestBody TeacherResponse teacherResponse) {
        return teacherService.update(id, teacherResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }


}

