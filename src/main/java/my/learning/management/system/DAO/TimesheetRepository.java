package my.learning.management.system.DAO;

import my.learning.management.system.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository <Timesheet, Long> {

}
