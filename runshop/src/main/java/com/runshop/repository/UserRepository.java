package com.runshop.repository;

import com.runshop.domain.User;

import java.util.List;

public interface UserRepository extends CRUDRepository <Long, User> {

     List<User> searchUserByWeight(Double weight);

    List<User> searchUserByHeight (Double height);

}
