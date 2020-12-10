package com.mercury.final_server.service;

import com.mercury.final_server.bean.PasswordHolder;
import com.mercury.final_server.bean.Purchase;
import com.mercury.final_server.dao.PurchaseDao;
import com.mercury.final_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    public Response addPurchaseToCart(Purchase purchase) {
        Purchase purchaseFromDB = purchaseDao.findById(purchase.getId()).get();
        if (purchaseFromDB.getId() == purchase.getId()) {
            purchaseFromDB = purchase;
            purchaseDao.save(purchaseFromDB);
            return new Response(true);
        } else {
            purchaseDao.save(purchase);
            return new Response(false);
        }
    }

}
