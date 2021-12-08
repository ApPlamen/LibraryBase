package com.tusofia.LibraryBase.services;

import java.util.List;

import com.tusofia.LibraryBase.exceptions.RepoSaveException;
import com.tusofia.LibraryBase.infrastructure.Repo;

public class CRUDService<Entity, EntityId> {
	
	protected Repo<Entity, EntityId> repo;
	
	public CRUDService(Repo<Entity, EntityId> repo) {
		this.repo = repo;
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
