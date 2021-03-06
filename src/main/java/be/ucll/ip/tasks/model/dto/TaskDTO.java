package be.ucll.ip.tasks.model.dto;

import be.ucll.ip.tasks.model.entity.Project;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDTO {

    private Long id;

    @NotEmpty(message = "Title is mandatory")
    @NotBlank(message = "Title may not be blank")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    @NotEmpty(message = "Description is mandatory")
    @NotBlank(message = "Description may not be blank")
    @Size(min = 3, message = "Description must be at least 3 characters long")
    private String description;

    @NotNull(message = "Due date is mandatory")
    @Future(message = "Due date must be a future date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    private List<SubTaskDTO> subTaskDTOs;

    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public List<SubTaskDTO> getSubTaskDTOs() {
        return subTaskDTOs;
    }

    public void setSubTaskDTOs(List<SubTaskDTO> subTaskDTOs) {
        this.subTaskDTOs = subTaskDTOs;
    }

    public void addSubTaskDTO(SubTaskDTO subTaskDTO){
        this.subTaskDTOs.add(subTaskDTO);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
