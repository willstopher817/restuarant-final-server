package com.mercury.final_server.service;

import com.mercury.final_server.bean.DeliveryInfo;
import com.mercury.final_server.dao.DeliveryInfoDao;
import com.mercury.final_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryInfoService {

    @Autowired
    DeliveryInfoDao deliveryInfoDao;

    public List<DeliveryInfo> getAllDeliveryInfo() {
        return deliveryInfoDao.findAll();
    }

    public DeliveryInfo getOneDeliveryInfoByOrderNum(int orderNum) {
        return deliveryInfoDao.findDeliveryInfoByOrderNum(orderNum);
    }

    public List<DeliveryInfo> getDeliveryInfoByUserId(int userId) {
        return deliveryInfoDao.findDeliveryInfoByUserId(userId);
    }

    public Response changeStage(DeliveryInfo deliveryInfo) {
        DeliveryInfo di = deliveryInfoDao.findById(deliveryInfo.getId()).get();
        di.setStage(deliveryInfo.getStage());
        deliveryInfoDao.save(di);
        return new Response(true);
    }

    public Response addDeliveryInfo(DeliveryInfo deliveryInfo) {
        deliveryInfoDao.save(deliveryInfo);
        return new Response(true);
    }

    // remove from cache.
    @CacheEvict(value = "orders", key = "#id")
    public Response deleteOrder(int id) {
        try {
            deliveryInfoDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }

}
