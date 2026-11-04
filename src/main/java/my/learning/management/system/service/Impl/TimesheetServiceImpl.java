package my.learning.management.system.service.Impl;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dao.CourseRepository;
import my.learning.management.system.dao.GroupRepository;
import my.learning.management.system.dao.TeacherRepository;
import my.learning.management.system.dao.TimesheetRepository;
import my.learning.management.system.dto.TimesheetRequest;
import my.learning.management.system.dto.TimesheetResponse;
import my.learning.management.system.exception.NotFoundException;
import my.learning.management.system.mapper.TimesheetMapper;
import my.learning.management.system.model.Course;
import my.learning.management.system.model.Group;
import my.learning.management.system.model.Teacher;
import my.learning.management.system.model.Timesheet;
import my.learning.management.system.service.TimesheetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository timesheetRepository;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final TimesheetMapper timesheetMapper;


    @Override
    public Page<TimesheetResponse> findAllTimesheets(Pageable pageable) {
        return timesheetRepository.findAll(pageable).map(timesheetMapper::toResponse);
    }

    @Override
    public TimesheetResponse findTimesheetById(Long id) {
        return timesheetRepository.findById(id).map(timesheetMapper::toResponse).orElseThrow(() -> new NotFoundException(
                String.format("Расписание с id %d не найдено", id)));

    }

    @Override
    @Transactional
    public TimesheetResponse create(TimesheetRequest request) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Курс с id %d не найден", request.getCourseId())));
        Group group = groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Группа с id %d не найдена", request.getGroupId())));
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Учитель с id %d не найден", request.getTeacherId())));

        Timesheet timesheet = new Timesheet();
        timesheet.setCourse(course);
        timesheet.setGroup(group);
        timesheet.setTeacher(teacher);
        timesheet.setStartDate(request.getStartDate());
        timesheet.setEndDate(request.getEndDate());

        return timesheetMapper.toResponse(timesheetRepository.save(timesheet));
    }

    @Override
    @Transactional
    public TimesheetResponse update(Long id ,TimesheetRequest request) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Курс с id %d не найден", request.getCourseId())));
        Group group = groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Группа с id %d не найдена", request.getGroupId())));
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Учитель с id %d не найден", request.getTeacherId())));
        Timesheet timesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Расписание с id %d не найдено", id)));

        timesheet.setCourse(course);
        timesheet.setGroup(group);
        timesheet.setTeacher(teacher);
        timesheet.setStartDate(request.getStartDate());
        timesheet.setEndDate(request.getEndDate());
        return timesheetMapper.toResponse(timesheetRepository.save(timesheet));
    }

    @Override
    @Transactional
    public void delete(Long id){
        if(!timesheetRepository.existsById(id)){
            throw new NotFoundException(String.format("Расписание с id %d не найдено", id));
        }
        timesheetRepository.deleteById(id);
    }

    @Override
    public Page<TimesheetResponse> findByGroupId(Long groupId, Pageable pageable){
        if(!groupRepository.existsById(groupId)){
            throw new NotFoundException(String.format("Группа с id %d не найдена", groupId));
        }
        return timesheetRepository.findByGroupId(groupId, pageable).map(timesheetMapper::toResponse);
    }

    @Override
    public Page<TimesheetResponse> findByTeacherId(Long teacherId, Pageable pageable){
        if (!teacherRepository.existsById(teacherId)) {
            throw new NotFoundException(String.format("Учитель с id %d не найден", teacherId));
        }
        return timesheetRepository.findByTeacherId(teacherId, pageable).map(timesheetMapper::toResponse);
    }
        }






