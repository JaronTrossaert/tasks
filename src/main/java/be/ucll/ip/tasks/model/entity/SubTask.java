package be.ucll.ip.tasks.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SubTask {

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
