package com.tusofia.LibraryBase.infrastructure;

import org.springframework.stereotype.Repository;

import com.tusofia.LibraryBase.entities.User;

@Repository
public interface UserRepo extends Repo<User, Integer> {

}
