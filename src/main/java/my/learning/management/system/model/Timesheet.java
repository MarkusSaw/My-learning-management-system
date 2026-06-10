package my.learning.management.system.model;


import jakarta.persistence.*;


@Entity
@Table(name = "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groupname")
    private String groupname;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "course")
    private int course;

    @Column(name = "dateofthelesson")
    private int dateofthelesson;
}
