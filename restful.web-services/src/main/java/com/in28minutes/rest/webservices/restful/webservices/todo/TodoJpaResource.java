package com.in28minutes.rest.webservices.restful.webservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaResource {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUsername(username);
//		return todoService.findAll();
		
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return todoJpaRepository.findById(id).get();
//		return todoService.findById(id);
		
	}
	
	//DELETE /delete/{username}/todos/{id}
	@DeleteMapping("/jpa/delete/{username}/todos/{id}")
	public ResponseEntity <Void> deleteTodo(
			@PathVariable String username, @PathVariable long id){
		
		todoJpaRepository.deleteById(id);
		
//		if(todo != null) {
//			return ResponseEntity.noContent().build();
//		}
//		Todo todo = todoService.deleteById(id);
		
		return ResponseEntity.notFound().build();
	}
	
	//Edit/Update a Todo
	//PUT /users/{username}/todos/{todo_id}
		@PutMapping("/jpa/users/{username}/todos/{id}")
		public ResponseEntity <Todo> updateTodo(
				@PathVariable String username, 
				@PathVariable long id, @RequestBody Todo todo){
//			Todo todoUpdate = todoService.save(todo);
			
			Todo todoUpdate = todoJpaRepository.save(todo);
			
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);			
		}
		
		@PostMapping("/jpa/users/{username}/todos")
		public ResponseEntity <Void> createTodo(
				@PathVariable String username, @RequestBody Todo todo){
//			Todo createdTodo = todoService.save(todo);
			System.out.println("aaa " + username);
			todo.setUsername(username);
			Todo createdTodo = todoJpaRepository.save(todo);
			//Location
			//Get current resource url
			//{id}
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			
			return ResponseEntity.created(uri).build();			
		}
	
}	