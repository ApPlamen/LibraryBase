package com.tusofia.LibraryBase.services;

import java.util.List;
import java.util.Optional;

import com.tusofia.LibraryBase.dtos.inputs.InputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UpdateDTO;
import com.tusofia.LibraryBase.entities.EntityModel;
import com.tusofia.LibraryBase.infrastructure.Repo;

public class CRUDService<Entity extends EntityModel, EntityId, InputDTOImp extends InputDTO<Entity>, UpdateDTOImp extends UpdateDTO<Entity, EntityId>> {
	
	protected Repo<Entity, EntityId> repo;
	
	public CRUDService(Repo<Entity, EntityId> repo) {
		this.repo = repo;
	}
	
	public Optional<Entity> getById(EntityId entityId) {
		return this.repo.findById(entityId);
	}
	
	public List<Entity> getAll() {
		return this.repo.findAll();
	}
	
	public Entity create(InputDTOImp dto) {
		return this.repo.save(dto.toEntity());
	}
	
	public Entity update(UpdateDTOImp dto) {
		Entity entity = this.repo.findById(dto.getId()).get();
		return this.repo.save(dto.toEntity(entity));
	}
	
	public void delete(UpdateDTOImp entity) {
		this.repo.delete(entity.toEntity());
	}
	
	public void deleteById(EntityId entityId) {
		this.repo.deleteById(entityId);
	}
}
