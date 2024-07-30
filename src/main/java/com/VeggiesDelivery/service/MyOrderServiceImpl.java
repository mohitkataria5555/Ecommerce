package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.MyOrders;
import com.VeggiesDelivery.repository.MyOrederRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyOrderServiceImpl implements MyOrderService {

    @Autowired
    private MyOrederRepositor myOrderRepo;

    @Override
    public MyOrders getOrderById(long id) {
        return myOrderRepo.findById(id).get();
    }

    @Override
    public List<MyOrders> getAllOrder() {
        return (List<MyOrders>) myOrderRepo.findAll();
    }

    @Override
    public void addOrder(MyOrders order) {
            myOrderRepo.save(order);
    }

    @Override
    public void UpdateOrder(long id, MyOrders order) {
        myOrderRepo.save(order);
    }

    @Override
    public void DeleteOrder(long id) {
    myOrderRepo.deleteById(id);
    }
}
