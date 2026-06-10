package my.learning.management.system.model;


import jakarta.persistence.*;


@Entity
@Table(name = "groupname")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


}
