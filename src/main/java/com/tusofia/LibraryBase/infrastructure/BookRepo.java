package com.tusofia.LibraryBase.infrastructure;

import org.springframework.stereotype.Repository;

import com.tusofia.LibraryBase.entities.Book;

@Repository
public interface BookRepo extends Repo<Book, Integer> {

}
