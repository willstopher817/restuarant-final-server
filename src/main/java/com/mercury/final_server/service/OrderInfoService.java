package com.mercury.final_server.service;

import com.mercury.final_server.bean.DeliveryInfo;
import com.mercury.final_server.bean.OrderInfo;
import com.mercury.final_server.dao.OrderInfoDao;
import com.mercury.final_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoDao orderInfoDao;

//    public List<OrderInfo> getOrderInfo(int userId) {
//        return orderInfoDao.findByUserId(userId);
//    }

    public List<OrderInfo> getOrderInfoByOrderNum(int orderNum) {
        return orderInfoDao.findByOrderNum(orderNum);
    }

    public Response addOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.save(orderInfo);
        return new Response(true);
    }

}
