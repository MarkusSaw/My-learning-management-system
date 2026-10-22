package my.learning.management.system.service.lmpl;

import lombok.AllArgsConstructor;
import my.learning.management.system.exception.BadRequestException;
import my.learning.management.system.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.learning.management.system.dao.CourseRepository;
import my.learning.management.system.dto.CourseResponse;
import my.learning.management.system.mapper.CourseMapper;
import my.learning.management.system.model.Course;
import my.learning.management.system.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    public  Page<CourseResponse> findAllCourses(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public CourseResponse findCourseById(Long id) {
        return repository.findById(id).map(mapper::toResponse).orElseThrow(() -> new NotFoundException("Курс с id " + id + " не найден"));
    }

    @Override
    public CourseResponse create(CourseResponse courseResponse) {
        if (repository.existsByName(courseResponse.getName())) {
            throw new BadRequestException("Курс с названием '" + courseResponse.getName() + "' уже существует");
        }
        Course course = mapper.toCourse(courseResponse);
        return mapper.toResponse(repository.save(course));
    }

    @Override
    public CourseResponse update(Long id, CourseResponse courseResponse) {
        Course existingCourse = repository.findById(id).orElseThrow(() -> new NotFoundException("Курс с id " + id + " не найден"));
        if (!existingCourse.getName().equals(courseResponse.getName())
                && repository.existsByName(courseResponse.getName())) {
            throw new BadRequestException("Курс с названием '" + courseResponse.getName() + "' уже существует");
        }
        Course course = mapper.toCourse(courseResponse);
        course.setId(id);
        return mapper.toResponse(repository.save(course));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Курс с id " + id + " не найден");
        }
        repository.deleteById(id);
    }
}