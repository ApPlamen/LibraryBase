package com.tusofia.LibraryBase.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tusofia.LibraryBase.entities.EntityModel;

public abstract class InputDTO<Entity extends EntityModel, EntityId> {
	
	@JsonIgnore
	public EntityId getId() {
		return null;
	}
	
	public abstract Entity toEntity();

}
