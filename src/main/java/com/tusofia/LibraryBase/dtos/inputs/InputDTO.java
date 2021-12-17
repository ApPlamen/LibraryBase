package com.tusofia.LibraryBase.dtos.inputs;

import com.tusofia.LibraryBase.entities.EntityModel;

public abstract class InputDTO<Entity extends EntityModel> {
	
	public abstract Entity toEntity();

}
