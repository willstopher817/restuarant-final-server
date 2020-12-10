package com.mercury.final_server.controller;

import com.mercury.final_server.bean.DeliveryInfo;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DeliveryInfoController {

    @Autowired
    DeliveryInfoService deliveryInfoService;

    @GetMapping("/deliveryInfo/oneOrder/{orderNum}")
    public DeliveryInfo getOneDeliveryInfo(@PathVariable("orderNum") int orderNum) {
        return deliveryInfoService.getOneDeliveryInfoByOrderNum(orderNum);
    }

    @GetMapping("/deliveryInfo")
    public List<DeliveryInfo> getAllDeliveryInfo() {
        return deliveryInfoService.getAllDeliveryInfo();
    }

    @GetMapping("/deliveryInfo/{userId}")
    public List<DeliveryInfo> getDeliveryInfoByUserId(@PathVariable("userId") int userId) {
        return deliveryInfoService.getDeliveryInfoByUserId(userId);
    }

    @PutMapping("/deliveryInfo")
    public Response changeStage(@RequestBody DeliveryInfo deliveryInfo) {
        return deliveryInfoService.changeStage(deliveryInfo);
    }

    @PostMapping("/deliveryInfo")
    public Response addDeliveryInfo(@RequestBody DeliveryInfo deliveryInfo) {
        return deliveryInfoService.addDeliveryInfo(deliveryInfo);
    }

    @DeleteMapping("/deliveryInfo/{id}")
    public Response deleteOrder(@PathVariable int id) {
        return deliveryInfoService.deleteOrder(id);
    }

}
