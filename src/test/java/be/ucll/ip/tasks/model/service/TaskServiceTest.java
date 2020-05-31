package be.ucll.ip.tasks.model.service;

import be.ucll.ip.tasks.model.dto.SubTaskDTO;
import be.ucll.ip.tasks.model.dto.TaskDTO;
import be.ucll.ip.tasks.model.entity.SubTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    void testGetTasks() {
        // setup
        int initTaskSize = taskService.getTasks().size();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("IP Minor Project");
        taskDTO.setDescription("Finalize the task manager");
        taskDTO.setDueDate(LocalDateTime.of(2020, 11, 11, 11, 11));
        taskService.addTask(taskDTO);

        // method to be tested
        List<TaskDTO> tasks = taskService.getTasks();

        // checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(initTaskSize + 1, tasks.size());
        TaskDTO task = tasks.get(tasks.size() - 1);
        assertNotNull(task);
    }

    @Test
    void testGetTask() {
        // setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("JUnit testing");
        taskDTO.setDescription("Test for getting a specific task");
        taskDTO.setDueDate(LocalDateTime.of(2020, 9, 9, 9, 9));
        taskService.addTask(taskDTO);

        // method to be tested
        TaskDTO task = taskService.getTask((long) taskService.getTasks().size());

        // checks
        assertNotNull(task);
        assertEquals("JUnit testing", task.getTitle());
        assertEquals("Test for getting a specific task", task.getDescription());
        assertEquals(LocalDateTime.of(2020, 9, 9, 9, 9), task.getDueDate());
    }

    @Test
    void testAddTask() {
        // setup
        long initSize = taskService.getTasks().size();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Testing the service class");
        taskDTO.setDescription("Checking whether all features work as intended");
        taskDTO.setDueDate(LocalDateTime.of(2020, 8, 8, 8, 8));

        // method to be tested
        taskService.addTask(taskDTO);

        // checks
        assertEquals(initSize + 1, taskService.getTasks().size());
        TaskDTO task = taskService.getTask((long) taskService.getTasks().size());
        assertEquals(taskDTO.getTitle(), task.getTitle());
        assertEquals(taskDTO.getDescription(), task.getDescription());
        assertEquals(taskDTO.getDueDate(), task.getDueDate());
    }

    @Test
    void testEditTask() {
        // setup
        Long id = (long) (taskService.getTasks().size() + 1);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Validate the important stuff");
        taskDTO.setDescription("Not much more to be said");
        taskDTO.setDueDate(LocalDateTime.of(2020, 12, 12, 12, 12));
        taskService.addTask(taskDTO);
        TaskDTO task = taskService.getTask(id);
        task.setTitle("Validate that stuff, again");
        task.setDescription("What else can I say");
        task.setDueDate(LocalDateTime.of(2021, 1, 1, 1, 1));

        // method to be tested
        taskService.editTask(task);

        // checks
        TaskDTO updatedTask = taskService.getTask(id);
        assertNotNull(updatedTask);
        assertEquals("Validate that stuff, again", updatedTask.getTitle());
        assertEquals("What else can I say", updatedTask.getDescription());
        assertEquals(LocalDateTime.of(2021, 1, 1, 1, 1), updatedTask.getDueDate());
    }

    @Test
    void testAddSubTask() {
        // setup
        TaskDTO task = taskService.getTask((long) taskService.getTasks().size());
        int initSubTaskSize = task.getSubTaskDTOs().size();
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Configure subtasks");
        subTaskDTO.setDescription("Certify and adjust subtasks where possible");

        // method to be tested
        taskService.addSubTask(task.getId(), subTaskDTO);

        // checks
        TaskDTO taskWithSubTask = taskService.getTask((long) taskService.getTasks().size());
        List<SubTaskDTO> subTaskDTOs = taskWithSubTask.getSubTaskDTOs();
        assertNotNull(subTaskDTOs);
        assertEquals(initSubTaskSize + 1, subTaskDTOs.size());
        assertEquals("Configure subtasks", subTaskDTOs.get(subTaskDTOs.size() - 1).getTitle());
        assertEquals("Certify and adjust subtasks where possible", subTaskDTOs.get(subTaskDTOs.size() - 1).getDescription());
    }
}
