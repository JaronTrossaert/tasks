package be.ucll.ip.tasks.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task {

    // Native generator to keep generated ID's separate between entities
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dueDate;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<SubTask> subTasks;

    // TODO empty constructor for entity class?

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

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
    }
}
