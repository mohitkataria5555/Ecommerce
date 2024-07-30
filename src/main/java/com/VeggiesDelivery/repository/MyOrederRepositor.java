package com.VeggiesDelivery.repository;

import com.VeggiesDelivery.entity.MyOrders;
import org.springframework.data.repository.CrudRepository;

public interface MyOrederRepositor extends CrudRepository<MyOrders,Long> {
}
