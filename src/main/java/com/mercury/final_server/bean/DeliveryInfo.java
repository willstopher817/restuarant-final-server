package com.mercury.final_server.bean;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERYINFO")
public class DeliveryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DELIVERYINFO_SEQ")
    @SequenceGenerator(name = "DELIVERYINFO_SEQ", sequenceName = "DELIVERYINFO_SEQ", allocationSize = 1)
    int id;
    @Column
    String name;
    @Column
    String phone;
    @Column
    String email;
    @Column
    String address1;
    @Column
    String address2;
    @Column
    String city;
    @Column
    String state;
    @Column
    String zip;
    @Column
    String time;
    @Column
    float total;
    @Column
    int stage;
    @Column(name = "USERID")
    private int userId;
    @Column(name = "ORDERNUM")
    private int orderNum;



    public DeliveryInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
