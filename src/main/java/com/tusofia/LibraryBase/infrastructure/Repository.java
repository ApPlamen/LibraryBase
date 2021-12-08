package com.tusofia.LibraryBase.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repository<entity, idType> extends JpaRepository<entity, idType> {

}
