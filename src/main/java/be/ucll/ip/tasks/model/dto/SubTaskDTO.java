package be.ucll.ip.tasks.model.dto;

import be.ucll.ip.tasks.model.entity.Task;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SubTaskDTO {

    private Long id;

    @NotEmpty(message = "Title is mandatory")
    @NotBlank(message = "Title may not be blank")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    @NotEmpty(message = "Description is mandatory")
    @NotBlank(message = "Description may not be blank")
    @Size(min = 3, message = "Description must be at least 3 characters long")
    private String description;

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
}
