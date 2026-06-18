package my.learning.management.system.dao;

import my.learning.management.system.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher, Long> {

}
