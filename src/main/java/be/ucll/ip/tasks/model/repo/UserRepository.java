package be.ucll.ip.tasks.model.repo;

import be.ucll.ip.tasks.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
