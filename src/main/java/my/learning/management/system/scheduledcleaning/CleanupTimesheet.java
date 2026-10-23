package my.learning.management.system.scheduledcleaning;

import lombok.RequiredArgsConstructor;
import my.learning.management.system.dao.TimesheetRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CleanupTimesheet {
    private final TimesheetRepository timesheetRepository;

    @Scheduled(cron = "${spring.app.cleanup.cron}")
    public void removeOldTimesheet(){
        timesheetRepository.deleteByDateOfTheLessonBefore(LocalDate.now().minusYears(1));
        System.out.println("Старое расписание удалено");
    }

}
