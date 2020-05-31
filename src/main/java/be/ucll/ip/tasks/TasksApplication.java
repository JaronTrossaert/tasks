package be.ucll.ip.tasks;

import be.ucll.ip.tasks.model.entity.Task;
import be.ucll.ip.tasks.model.repo.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CommandLineRunner demo(TaskRepository taskRepository) {
		return (args) -> {
			// save a dummy task
			Task task1 = new Task();
			task1.setTitle("First exercise");
			task1.setDescription("Clear the tutorial");
			task1.setDueDate(LocalDateTime.of(2020, 10, 10, 10, 10));
			taskRepository.save(task1);
		};
	}

}
