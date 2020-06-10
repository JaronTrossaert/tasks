package be.ucll.ip.tasks.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ProjectDTO {

    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @NotBlank(message = "Name may not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    private List<TaskDTO> taskDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDTO> getTaskDTOs() {
        return taskDTOs;
    }

    public void setTaskDTOs(List<TaskDTO> taskDTOs) {
        this.taskDTOs = taskDTOs;
    }

    public void addTaskDTO(TaskDTO taskDTO){
        this.taskDTOs.add(taskDTO);
    }
}
