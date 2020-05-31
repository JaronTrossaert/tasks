package be.ucll.ip.tasks.rest.controller;

import be.ucll.ip.tasks.model.dto.TaskDTO;
import be.ucll.ip.tasks.model.service.TaskService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }
}
