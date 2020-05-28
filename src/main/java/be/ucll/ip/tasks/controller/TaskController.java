package be.ucll.ip.tasks.controller;

import be.ucll.ip.tasks.dto.TaskDTO;
import be.ucll.ip.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("task", taskService.getTask(id));
        } catch (IllegalArgumentException e) {
            model.addAttribute("taskNotFound", e.getMessage());
        }
        return "task";
    }

    @GetMapping("/new")
    public String getNewTaskForm(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        return "new_task";
    }

    @PostMapping("/new")
    public String postNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_task";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }
}
