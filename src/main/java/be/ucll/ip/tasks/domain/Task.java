package be.ucll.ip.tasks.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;

    public Task() {
    }

    public Task(int id, String title, String description, LocalDateTime dueDate) {
        this.id = (long) id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
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

    @Override
    public String toString() {
        String pattern = "hh:mm a";
        return "Task " +
                (this.id + 1) +
                ": due " +
                this.dueDate.getMonth() +
                " " +
                this.dueDate.getDayOfMonth() +
                " " +
                this.dueDate.getYear() +
                " at " +
                this.dueDate.getHour() +
                this.dueDate.format(DateTimeFormatter.ofPattern(pattern));
    }
}
