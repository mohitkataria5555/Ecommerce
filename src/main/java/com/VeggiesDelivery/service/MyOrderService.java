package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Cart;
import com.VeggiesDelivery.entity.MyOrders;

import java.util.List;

public interface MyOrderService {


    MyOrders getOrderById(long id);
    List<MyOrders> getAllOrder();
    void addOrder(MyOrders order);
    void UpdateOrder(long id, MyOrders order);
    void DeleteOrder(long id);
}
