package com.in28minutes.rest.webservices.restful.webservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in 28 minutes", "Diego112", new Date(), false));
		todos.add(new Todo(++idCounter, "in 28 minutes", "Ambar", new Date(), false));
		todos.add(new Todo(++idCounter, "in 28 minutes", "Gaspar1", new Date(), false));
		todos.add(new Todo(++idCounter, "in 28 minutes", "Taína", new Date(), false));
	}

	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo == null)
			return null;
		if(todos.remove(todo))
			return todo;
		
		return null;
		
	}
	
	public Todo findById(long id) {
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
