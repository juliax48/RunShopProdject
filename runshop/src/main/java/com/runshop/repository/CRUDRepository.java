package com.runshop.repository;

import java.util.List;

public interface CRUDRepository <K, T>  {
    T findOne(K id); //

    List<T> findAll();

    T create(T object);

    T update(T object);

    void delete(K id);

}

//    CRUD - operations
//    Create - Insert
//    Read - Select (by id, all, filtered)
//    Update
//    Delete
//    Optional<T> findOne(K id); //
//    T findById(K id); //throw new EntityNotFoundException("User with id " + id + " ")

