package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.domain.Task;
import be.ucll.ip.tasks.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository repository;

    @Autowired
    public TasksServiceImpl(TasksRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }
}
