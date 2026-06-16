package my.learning.management.system.DAO;

import my.learning.management.system.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository <Group, Long> {

}
