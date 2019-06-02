package org.tgo.todo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${env}/todo")
public class TodoController {

	private TodoRepository repository;

	public TodoController(TodoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<Iterable<Todo>> findAll() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(repository.findAll());
	}

}
