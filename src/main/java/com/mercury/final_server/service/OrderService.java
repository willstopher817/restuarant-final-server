package com.mercury.final_server.service;

import com.mercury.final_server.bean.Order;
import com.mercury.final_server.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public List<Order> getAllOrder() {
        return orderDao.findAll();
    }


    public List<Order> getOrdersById(int id) {
        return orderDao.findById(id);
    }

//    public Order getOneOrder(int id) {
//        return orderDao.findById(id).orElse(new Order());
//    }

}
