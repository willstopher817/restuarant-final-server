package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Order;
import com.mercury.final_server.bean.OrderInfo;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;

//    @GetMapping("/{userId}")
//    public List<OrderInfo> getOrderInfo(@PathVariable("userId") int userId) {
//        return orderInfoService.getOrderInfo(userId);
//    }

    @GetMapping("/{orderNum}")
    public List<OrderInfo> getOrderInfoByOrderNum(@PathVariable("orderNum") int orderNum) {
        return orderInfoService.getOrderInfoByOrderNum(orderNum);
    }


    @PostMapping
    public Response addOrderInfo(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.addOrderInfo(orderInfo);
    }
}
