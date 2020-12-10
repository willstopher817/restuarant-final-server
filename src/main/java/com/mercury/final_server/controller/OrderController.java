package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Order;
import com.mercury.final_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(name = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    // GET /orders
    @GetMapping("/orders")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/orders/{id}")
    public List<Order> getAllOrdersByUserId(@PathVariable("id") int id) {
        return orderService.getOrdersById(id);
    }


//    @GetMapping("/orders/{id}")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
//    public Order getOneOrder(@PathVariable("id") int id) {
//        return orderService.getOneOrder(id);
//    }



}
