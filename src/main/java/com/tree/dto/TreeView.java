package com.tree.dto;

import java.util.List;

/**
 * Created by TFR on 2017/8/5.
 */
public class TreeView {

    private String name;

    private List<TreeView> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeView> getChildren() {
        return children;
    }

    public void setChildren(List<TreeView> children) {
        this.children = children;
    }
}
