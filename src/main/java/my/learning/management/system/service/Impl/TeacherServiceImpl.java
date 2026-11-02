package my.learning.management.system.service.Impl;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.dto.TeacherResponse;
import my.learning.management.system.exception.BadRequestException;
import my.learning.management.system.exception.NotFoundException;
import my.learning.management.system.mapper.TeacherMapper;
import my.learning.management.system.model.Teacher;
import my.learning.management.system.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

private final TeacherRepository teacherRepository;
private final TeacherMapper teacherMapper;

    @Override
    public Page<TeacherResponse> findAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable).map(teacherMapper::toResponse);
    }

    @Override
    public TeacherResponse findTeacherById(Long id) {
        return teacherRepository.findById(id).map(teacherMapper::toResponse).orElseThrow(() -> new NotFoundException(
                String.format("Учитель с id %d не найден", id)));
    }

    @Override
    @Transactional
    public TeacherResponse create(TeacherResponse teacherResponse) {
        if (teacherRepository.existsByNameAndLastname(
                teacherResponse.getName(),
                teacherResponse.getLastname())) {
            throw new BadRequestException(String.format("Учитель '%s %s' уже существует",
                    teacherResponse.getName(),
                    teacherResponse.getLastname())
            );
        }
        Teacher teacher = teacherMapper.toTeacher(teacherResponse);
        return teacherMapper.toResponse(teacherRepository.save(teacher));
    }

    @Override
    @Transactional
    public TeacherResponse update(Long id, TeacherResponse teacherResponse) {
        Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Учитель с id %d не найден", id)));
        if (!existingTeacher.getName().equals(teacherResponse.getName())
                || !existingTeacher.getLastname().equals(teacherResponse.getLastname())){
            if (teacherRepository.existsByNameAndLastname(
                    teacherResponse.getName(),
                    teacherResponse.getLastname())) {
                throw new BadRequestException(String.format("Учитель '%s %s' уже существует",
                        teacherResponse.getName(),
                        teacherResponse.getLastname()));
            }
        }
        Teacher teacher = teacherMapper.toTeacher(teacherResponse);
        teacher.setId(id);
        return teacherMapper.toResponse(teacherRepository.save(teacher));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException(String.format("Учитель с id %d не найден", id));
        }
        teacherRepository.deleteById(id);
    }

}
