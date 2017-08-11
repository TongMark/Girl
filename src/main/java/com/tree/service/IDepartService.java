package com.tree.service;

import com.tree.dto.Depart;
import com.tree.dto.TreeView;

import java.util.List;

/**
 * Created by TFR on 2017/8/4.
 */
public interface IDepartService {

    /**
     * 新增
     * @param depart
     */
    Depart insertDepart(Depart depart);


    List<TreeView> treeView();

    List<Depart> selectAll();

}
