package com.mercury.final_server.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msi_user")
public class ToggleDisable {

    @Id
    private long id;
    @Column(name = "disable")
    private String disable;

    public ToggleDisable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "ToggleDisable{" +
                "id=" + id +
                ", disable='" + disable + '\'' +
                '}';
    }
}
