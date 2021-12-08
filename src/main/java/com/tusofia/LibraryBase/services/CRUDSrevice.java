package com.tusofia.LibraryBase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tusofia.LibraryBase.exceptions.RepoSaveException;
import com.tusofia.LibraryBase.infrastructure.Repository;

public class CRUDSrevice<Entity, EntityId> {
	
	@Autowired
	protected Repository<Entity, EntityId> repo;

	public CRUDSrevice() {
	}
	
	public Entity getById(EntityId entityId) {
		return this.repo.getById(entityId);
	}
	
	public List<Entity> getAll() {
		return this.repo.findAll();
	}
	
	public Entity save(Entity entity) throws RepoSaveException {
		return this.repo.save(entity);
	}
	
	public void delete(Entity entity) {
		this.repo.delete(entity);
	}
	
	public void deleteById(EntityId entityId) {
		this.repo.deleteById(entityId);
	}
}
