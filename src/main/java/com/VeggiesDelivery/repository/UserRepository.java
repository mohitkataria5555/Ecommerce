package com.VeggiesDelivery.repository;

import com.VeggiesDelivery.entity.UserSignUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserSignUp, String> {
}
