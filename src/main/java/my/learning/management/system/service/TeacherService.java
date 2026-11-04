package my.learning.management.system.service;


import my.learning.management.system.dto.TeacherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<TeacherResponse> findAllTeachers(Pageable pageable);
    TeacherResponse findTeacherById(Long id);
    TeacherResponse create(TeacherResponse teacherResponse);
    TeacherResponse update(Long id, TeacherResponse teacherResponse);
    void delete(Long id);
}
