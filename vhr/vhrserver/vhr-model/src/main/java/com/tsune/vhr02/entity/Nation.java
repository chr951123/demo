package com.tsune.vhr02.entity;

import java.io.Serializable;

public class Nation implements Serializable {
    private Integer id;

    private String name;

    public Nation() {
    }

    public Nation(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}