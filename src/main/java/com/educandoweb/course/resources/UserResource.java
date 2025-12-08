package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users") //Para pesquisa do localhost
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){ //Retorna a respota das requisições web
		User usr = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(usr);
	}
}
