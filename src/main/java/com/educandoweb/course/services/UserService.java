package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.educandoweb.course.config.TestConfig;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    private final TestConfig testConfig;
	
	@Autowired
	private UserRepository userRepository;

    UserService(TestConfig testConfig) {
        this.testConfig = testConfig;
    }
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long Id) {
		Optional<User> obj = userRepository.findById(Id); 
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void Delete(Long id) {
		try { //Se não existir
			if(!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
			userRepository.deleteById(id);
		}
		catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	//Atualizar de acordo com oq chega do obj
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
