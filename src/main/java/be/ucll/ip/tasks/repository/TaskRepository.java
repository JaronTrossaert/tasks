package be.ucll.ip.tasks.repository;

import be.ucll.ip.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
