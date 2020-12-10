package com.mercury.final_server.bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "MSI_ORDER")
public class Order {

    @Id
    private int id;
    @Column
    private LocalDate purchase_date;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;  // one user
    // why only @OneToMany is not enough??
    // Order -> Purchase
    // JPA doesn't know which field in Purchase is holding the relationship
    @OneToMany(mappedBy = "order")  // order here is order in Purchase line 15
    private Set<Purchase> purchases;    // a set of purchases, include purchases in order when order is accessed

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

}
