package com.mercury.final_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "MSI_ORDER_MENU")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MSI_ORDER_MENU_SEQ_GEN")
    @SequenceGenerator(name = "MSI_ORDER_MENU_SEQ_GEN", sequenceName = "MSI_ORDER_MENU_SEQ_GEN", allocationSize = 1)
    private long id;
    @Column
    private int qty;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore // ignore the field when jackson convert java object to json
    private Order order;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    public Purchase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
