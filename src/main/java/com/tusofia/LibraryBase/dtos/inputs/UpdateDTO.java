package com.tusofia.LibraryBase.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tusofia.LibraryBase.entities.EntityModel;

public abstract class UpdateDTO<Entity extends EntityModel, EntityId> {

	@JsonProperty
	private EntityId id;
	
	public UpdateDTO() {
	}

	public EntityId getId() {
		return id;
	}

	public void setId(EntityId id) {
		this.id = id;
	}
	
	public abstract Entity toEntity(Entity entity);

}
