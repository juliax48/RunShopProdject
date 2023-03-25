package com.runshop.repository.implementUser;

import com.runshop.entity.User;
import com.runshop.repository.CRUDRepository;

import java.util.List;

public interface UserRepository extends CRUDRepository<Long, User> {

     List<User> searchUserByWeight(Double weight);

    List<User> searchUserByHeight (Double height);

    List<User> getAverageHeight (Double height);
    List<User> getAverageWeight (Double weight);


}
