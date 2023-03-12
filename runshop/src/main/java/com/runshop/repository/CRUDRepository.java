package com.runshop.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CRUDRepository <K, T>  {
    Optional<T> findOne(T object) throws SQLException;

    T findById (K id) throws EntityNotFoundException;

    List<T> findAll();

    T create(T object);

    T update(T object);

    T delete(K id) throws EntityNotFoundException;

}

//    CRUD - operations
//    Create - Insert
//    Read - Select (by id, all, filtered)
//    Update
//    Delete
//    Optional<T> findOne(K id); //
//    T findById(K id); //throw new EntityNotFoundException("User with id " + id + " ")

