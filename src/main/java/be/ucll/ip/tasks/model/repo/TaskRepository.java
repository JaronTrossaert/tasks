package be.ucll.ip.tasks.model.repo;

import be.ucll.ip.tasks.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
