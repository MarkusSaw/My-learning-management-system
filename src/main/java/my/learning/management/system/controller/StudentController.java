package my.learning.management.system.controller;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dto.StudentResponse;
import my.learning.management.system.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        return studentService.findAllStudents(pageable);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@RequestBody StudentResponse studentResponse) {
        return studentService.create(studentResponse);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentResponse studentResponse) {
        return studentService.update(id, studentResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.findStudentById(id);
    }

}

