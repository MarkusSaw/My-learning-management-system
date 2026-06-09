package my.learning.management.system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Сourse {

    @Column(name = "name")
    private String name;

    @Column(name = "coursedescription")
    private String coursedescription ;

}
