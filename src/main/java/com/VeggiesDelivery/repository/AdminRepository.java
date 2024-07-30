package com.VeggiesDelivery.repository;

import com.VeggiesDelivery.entity.AdminLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminLogin,Long> {
}
