package be.ucll.ip.tasks.model.service;

import be.ucll.ip.tasks.model.dto.SubTaskDTO;
import be.ucll.ip.tasks.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTask(Long id);

    void addTask(TaskDTO taskDTO);

    void editTask(TaskDTO taskDTO);

    void addSubTask(Long id, SubTaskDTO subTaskDTO);
}
