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

import com.tusofia.LibraryBase.dtos.inputs.InputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UpdateDTO;
import com.tusofia.LibraryBase.entities.EntityModel;
import com.tusofia.LibraryBase.services.CRUDService;

public class CRUDController<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>> {

	@Autowired
	protected CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp> service;
	
	public CRUDController(CRUDService<Entity, EntityId, InputDTOImp, UpdateDTOImp> service) {
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
	public Entity create(@RequestBody InputDTOImp entity) {
		return this.service.create(entity);
	}
	
	@PutMapping("update")
	public Entity update(@RequestBody UpdateDTOImp entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("delete/{entityId}")
	public void deleteById(@PathVariable EntityId entityId) {
		this.service.deleteById(entityId);
	}

}
