package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(int id);
}
