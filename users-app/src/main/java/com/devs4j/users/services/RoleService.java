package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.repositories.RoleRepository;
import com.devs4j.users.entities.Role;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getRoles(){
		return (List<Role>) repository.findAll();
	}
	
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = repository.findById(roleId);
		
		if(result.isPresent()) {
			return repository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}
	
	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		
		if(result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}
}
