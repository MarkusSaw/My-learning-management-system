package my.learning.management.system.service.Impl;

import lombok.RequiredArgsConstructor;
import my.learning.management.system.dao.GroupRepository;
import my.learning.management.system.dao.StudentRepository;
import my.learning.management.system.dto.StudentResponse;
import my.learning.management.system.exception.BadRequestException;
import my.learning.management.system.exception.NotFoundException;
import my.learning.management.system.mapper.StudentMapper;
import my.learning.management.system.model.Group;
import my.learning.management.system.model.Student;
import my.learning.management.system.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GroupRepository groupRepository;

    @Override
    public Page<StudentResponse> findAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable).map(studentMapper::toResponse);
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        return studentRepository.findById(id).map(studentMapper::toResponse).orElseThrow(() -> new NotFoundException(
                String.format("Студент с id %d не найден", id)));
    }

    @Override
    @Transactional
    public StudentResponse create(StudentResponse studentResponse) {
        if (studentRepository.existsByNameAndLastnameAndGroupTitle(
                studentResponse.getName(),
                studentResponse.getLastname(),
                studentResponse.getGroupName())) {
            throw new BadRequestException(String.format("Студент '%s %s' в группе '%s' уже существует",
                            studentResponse.getName(),
                            studentResponse.getLastname(),
                            studentResponse.getGroupName())
            );
        }
        Student student = studentMapper.toStudent(studentResponse);
        Group group = groupRepository.findByTitle(studentResponse.getGroupName())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Группа '%s' не найдена", studentResponse.getGroupName())));
        student.setGroup(group);
        return studentMapper.toResponse(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentResponse update(Long id, StudentResponse studentResponse) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Студент с id %d не найден", id)));
        if (!existingStudent.getName().equals(studentResponse.getName())
                || !existingStudent.getLastname().equals(studentResponse.getLastname())
                || !existingStudent.getGroup().getTitle().equals(studentResponse.getGroupName())) {
            if (studentRepository.existsByNameAndLastnameAndGroupTitle(
                    studentResponse.getName(),
                    studentResponse.getLastname(),
                    studentResponse.getGroupName())) {
                throw new BadRequestException(String.format("Студент '%s %s' в группе '%s' уже существует",
                        studentResponse.getName(),
                        studentResponse.getLastname(),
                        studentResponse.getGroupName()));
            }
        }
            Student student = studentMapper.toStudent(studentResponse);
            student.setId(id);
            Group group = groupRepository.findByTitle(studentResponse.getGroupName())
                    .orElseThrow(() -> new NotFoundException(
                            String.format("Группа '%s' не найдена", studentResponse.getGroupName())));
            student.setGroup(group);
            return studentMapper.toResponse(studentRepository.save(student));
        }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException(String.format("Студент с id %d не найден", id));
        }
        studentRepository.deleteById(id);
    }

}
