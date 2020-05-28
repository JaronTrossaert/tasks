package be.ucll.ip.tasks.repository;

import be.ucll.ip.tasks.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<Task> list;

    public TaskRepository() {
        list = new ArrayList<>();
        list.add(new Task(0, "Groceries", "Need food!",
                LocalDateTime.of(2020, 3, 20, 10, 0)));
        list.add(new Task(1, "IPM Project", "Gotta pass!",
                LocalDateTime.of(2020, 3, 21, 18, 0)));
        list.add(new Task(2, "Barber", "Want haircut!",
                LocalDateTime.of(2020, 3, 27, 17, 0)));
    }

    public List<Task> getTasks() {
        return list;
    }

    public Task getTask(int id) {
        try {
            return list.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Task not found");
        }
    }
}
