package com.runshop.repository;

import com.runshop.domain.User;

public interface UserRepository extends CRUDRepository <Long, User> {

    void searchUser();
}
