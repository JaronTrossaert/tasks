package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.domain.Task;
import be.ucll.ip.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(int id);

    void addTask(TaskDTO taskDTO);
}
