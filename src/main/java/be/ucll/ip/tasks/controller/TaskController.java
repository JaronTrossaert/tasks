package be.ucll.ip.tasks.controller;

import be.ucll.ip.tasks.model.dto.SubTaskDTO;
import be.ucll.ip.tasks.model.dto.TaskDTO;
import be.ucll.ip.tasks.model.service.TaskService;
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
    public String getTask(Model model, @PathVariable("id") long id) {
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

    @GetMapping("/edit/{id}")
    public String getEditTaskForm(Model model, @PathVariable("id") long id) {
        // TODO add edit task shortcuts
        try {
            model.addAttribute("task", taskService.getTask(id));
            model.addAttribute("taskId", id);
        } catch (IllegalArgumentException e) {
            model.addAttribute("taskNotFound", e.getMessage());
        }
        return "edit_task";
    }

    @PostMapping("/edit")
    public String postEditedTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_task";
        }
        // TODO add error handling for editing task
        taskService.editTask(taskDTO);
        return "redirect:/tasks" + "/" + taskDTO.getId();
    }

    @GetMapping("/{id}/sub/create")
    public String getNewSubTaskForm(Model model, @PathVariable("id") Long id){
        model.addAttribute("id", id );
        model.addAttribute("subTaskDTO", new SubTaskDTO());
        return "new_sub";
    }

    @PostMapping("/{id}/sub/create")
    public String postNewSubTask(@PathVariable("id") Long id,
                                 @ModelAttribute @Valid SubTaskDTO subTaskDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_sub";
        }
        taskService.addSubTask(id, subTaskDTO);
        return "redirect:/tasks" + "/" + + id;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }
}
