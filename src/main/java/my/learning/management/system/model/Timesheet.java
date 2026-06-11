package my.learning.management.system.model;


import jakarta.persistence.*;

import java.util.List;


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



    public Timesheet(String groupname, String teacher, int course, int dateofthelesson) {
        this.groupname = groupname;
        this.teacher = teacher;
        this.course = course;
        this.dateofthelesson = dateofthelesson;
    }

    public Timesheet(){
    }

    public Long getId() {
        return id;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCourse() {
        return course;
    }

    public int getDateofthelesson() {
        return dateofthelesson;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setDateofthelesson(int dateofthelesson) {
        this.dateofthelesson = dateofthelesson;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
