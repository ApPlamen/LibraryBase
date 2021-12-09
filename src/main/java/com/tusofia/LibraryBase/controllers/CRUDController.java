package com.tusofia.LibraryBase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tusofia.LibraryBase.services.CRUDService;

public class CRUDController<Entity, EntityId> {

	@Autowired
	protected CRUDService<Entity, EntityId> service;
	
	public CRUDController(CRUDService<Entity, EntityId> service) {
		this.service = service;
	}
	
	@GetMapping("get/{entityId}")
	public Optional<Entity> getById(@PathVariable EntityId entityId) {
		return this.service.getById(entityId);
	}
	
	@GetMapping("get-all")
	public List<Entity> getAll() {
		return this.service.getAll();
	}
	
	@PostMapping("create")
	public Entity create(@RequestBody Entity entity) {
		return this.service.save(entity);
	}
	
	@PutMapping("update")
	public Entity update(@RequestBody Entity entity) {
		return this.service.save(entity);
	}
	
	@DeleteMapping("delete")
	public void delete(@RequestBody Entity entity) {
		this.service.delete(entity);
	}
	
	@DeleteMapping("delete/{entityId}")
	public void deleteById(@PathVariable EntityId entityId) {
		this.service.deleteById(entityId);
	}

}
