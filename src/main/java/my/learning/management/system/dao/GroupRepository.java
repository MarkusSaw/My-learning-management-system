package my.learning.management.system.dao;

import my.learning.management.system.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository <Group, Long> {

    boolean existsByTitle(String title);
    Optional<Group> findByTitle(String title);
}
