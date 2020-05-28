package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTask(Long id);

    void addTask(TaskDTO taskDTO);
}
