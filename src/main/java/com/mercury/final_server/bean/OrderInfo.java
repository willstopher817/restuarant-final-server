package com.mercury.final_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ORDERINFO")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDERINFO_SEQ")
    @SequenceGenerator(name = "ORDERINFO_SEQ", sequenceName = "ORDERINFO_SEQ", allocationSize = 1)
    private int id;
    @Column(name = "USERID")
    private int userId;
    @Column(name = "FOODID")
    private int foodId;
    @Column(name = "ORDERNUM")
    private int orderNum;
    @Column
    private int qty;
    @Column
    private int price;
    @Column
    private String IMG;
    @Column(name = "FOODNAME")
    private String foodName;

    public OrderInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
