package my.learning.management.system.dao;

import my.learning.management.system.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Long> {

}
