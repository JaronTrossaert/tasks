package be.ucll.ip.tasks.model.service;

import be.ucll.ip.tasks.model.dto.SubTaskDTO;
import be.ucll.ip.tasks.model.entity.SubTask;
import be.ucll.ip.tasks.model.entity.Task;
import be.ucll.ip.tasks.model.dto.TaskDTO;
import be.ucll.ip.tasks.model.repo.SubTaskRepository;
import be.ucll.ip.tasks.model.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, SubTaskRepository subTaskRepository) {
        this.taskRepository = taskRepository;
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(Long id) {
        return taskRepository.findById(id).map(this::convert)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setSubTasks(new ArrayList<>());
        taskRepository.save(task);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        // TODO think about whether throwing this exception is useful
        Task task = taskRepository.findById(taskDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        // editing of subtasks not supported
        taskRepository.save(task);
    }

    @Override
    public void addSubTask(Long id, SubTaskDTO subTaskDTO) {
        SubTask subTask = new SubTask();
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());
        // TODO think about whether throwing this exception is useful
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        subTask.setTask(task);
        task.addSubTask(subTask);
        subTaskRepository.save(subTask);
        taskRepository.save(task);
    }

    private TaskDTO convert(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        List<SubTaskDTO> subTaskDTOs = new ArrayList<>();
        for (SubTask subTask: task.getSubTasks()) {
            SubTaskDTO subTaskDTO = new SubTaskDTO();
            subTaskDTO.setId(subTask.getId());
            subTaskDTO.setTitle(subTask.getTitle());
            subTaskDTO.setDescription(subTask.getDescription());
            subTaskDTOs.add(subTaskDTO);
        }
        dto.setSubTaskDTOs(subTaskDTOs);
        return dto;
    }
}
