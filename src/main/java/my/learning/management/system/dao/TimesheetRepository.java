package my.learning.management.system.dao;

import my.learning.management.system.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface TimesheetRepository extends JpaRepository <Timesheet, Long> {

    void deleteByEndDateBefore(LocalDate date);
    Page<Timesheet> findByGroupId(Long groupId, Pageable pageable);
    Page<Timesheet> findByTeacherId(Long teacherId, Pageable pageable);

}
