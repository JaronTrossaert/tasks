package be.ucll.ip.tasks.model.repo;

import be.ucll.ip.tasks.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
