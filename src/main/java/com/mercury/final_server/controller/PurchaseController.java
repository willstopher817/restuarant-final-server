package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Purchase;
import com.mercury.final_server.dao.PurchaseDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseDao purchaseDao;

    @PostMapping
    public Response addPurchase(@RequestBody Purchase purchase) {
        return purchaseService.addPurchaseToCart(purchase);
    }

}
