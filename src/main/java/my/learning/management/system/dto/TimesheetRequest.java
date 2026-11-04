package my.learning.management.system.dto;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimesheetRequest {
    private Long courseId;
    private Long groupId;
    private Long teacherId;
    private LocalDate startDate;
    private LocalDate endDate;
}