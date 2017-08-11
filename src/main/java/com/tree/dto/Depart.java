package com.tree.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by TFR on 2017/8/4.
 */
@Entity
public class Depart {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer anode;

    private Integer fnode;

    private Integer lnode;

    private Integer cnode;

    private String dptname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnode() {
        return anode;
    }

    public void setAnode(Integer anode) {
        this.anode = anode;
    }

    public Integer getFnode() {
        return fnode;
    }

    public void setFnode(Integer fnode) {
        this.fnode = fnode;
    }

    public Integer getLnode() {
        return lnode;
    }

    public void setLnode(Integer lnode) {
        this.lnode = lnode;
    }

    public Integer getCnode() {
        return cnode;
    }

    public void setCnode(Integer cnode) {
        this.cnode = cnode;
    }

    public String getDptname() {
        return dptname;
    }

    public void setDptname(String dptname) {
        this.dptname = dptname;
    }
}
