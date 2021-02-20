package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TodoItem;
import com.example.demo.repository.TodoRepository;
import com.sun.istack.NotNull;

@RestController
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	public TodoRepository todoRepository;
	
	@GetMapping
	public List<TodoItem> findAll(){
		return todoRepository.findAll();
	}

	@PostMapping
	public TodoItem save(@Validated @NotNull @RequestBody TodoItem todoItem) {
		return todoRepository.save(todoItem);
	}
	
	@PutMapping
	public TodoItem update(@Validated @NotNull @RequestBody TodoItem todoItem) {
		return todoRepository.save(todoItem);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		 todoRepository.deleteById(id);
	}
	
}
