package my.learning.management.system.model;


import jakarta.persistence.*;


@Entity

@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "group_name")
    private String groupname;

@ManyToOne
@JoinColumn(name = "course_id")
private Course course ;

@ManyToOne
@JoinColumn(name = "group_id")
private Group group;

@ManyToOne
@JoinColumn(name = "teacher_id")
private Teacher teacher;

@ManyToOne
@JoinColumn(name = "timesheet_id")
private Timesheet timesheet;

    public Student(String name, String lastname, String groupname) {
        this.name = name;
        this.lastname = lastname;
        this.groupname = groupname;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }
}
