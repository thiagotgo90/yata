package org.tgo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tgo.todo.todo.Todo;
import org.tgo.todo.todo.TodoRepository;

@SpringBootApplication
public class YetAnotherTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YetAnotherTodoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(TodoRepository repository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				repository.save(new Todo(1, "Study docker"));
			}
		};
	}

}
