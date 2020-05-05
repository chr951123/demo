package com.tsune.vhr02.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Joblevel implements Serializable {
    private Integer id;

    private String name;

    private String titlelevel;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "Asia/Shanghai")
    private Date createdate;

    private Boolean enabled;

    public Joblevel() {
    }

    public Joblevel(String name) {
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

    public String getTitlelevel() {
        return titlelevel;
    }

    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}