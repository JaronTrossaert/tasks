package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.domain.Task;
import be.ucll.ip.tasks.dto.TaskDTO;
import be.ucll.ip.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }

    @Override
    public Task getTask(int id) {
        return repository.getTask(id);
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        repository.addTask(task);
    }
}
