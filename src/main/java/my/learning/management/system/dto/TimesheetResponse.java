package my.learning.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TimesheetResponse {

    private Long id;
    private String groupname;
    private String teacher;
    private int course;
    private int dateofthelesson;
}
