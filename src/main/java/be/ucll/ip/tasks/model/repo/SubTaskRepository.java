package be.ucll.ip.tasks.model.repo;

import be.ucll.ip.tasks.model.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
