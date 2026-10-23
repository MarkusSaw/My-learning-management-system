package my.learning.management.system.dao;

import my.learning.management.system.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TimesheetRepository extends JpaRepository <Timesheet, Long> {

    void deleteByDateOfTheLessonBefore(LocalDate date);

}
