package my.learning.management.system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupname;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "course")
    private int course;

    @Column(name = "date_of_the_lesson")
    private int dateofthelesson;

    @OneToMany(mappedBy = "timesheet")
    private List<Student> students;


}
