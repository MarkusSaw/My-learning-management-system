package my.learning.management.system.service;


import my.learning.management.system.dto.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<StudentResponse> findAllStudents(Pageable pageable);
    StudentResponse findStudentById(Long id);
    StudentResponse create(StudentResponse studentResponse);
    StudentResponse update(Long id, StudentResponse studentResponse);
    void delete(Long id);
}
