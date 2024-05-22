package com.jmc.htdh.model.actor.dhqt;

import java.util.Date;

public class BPDHQT {
    private String name;
    private String address;
    private String username;

    private Date date;

    public BPDHQT(String name, String address, String username, Date date) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
