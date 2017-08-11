package com.tree.service.impl;

import com.tree.dto.Depart;
import com.tree.dto.TreeView;
import com.tree.repository.DepartRepository;
import com.tree.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TFR on 2017/8/4.
 */
@Service
public class DepartServiceImpl implements IDepartService {

    @Autowired
    private DepartRepository departRepository;

    private List<TreeView> treeViews = new ArrayList<>();

    @Override
    public Depart insertDepart(Depart depart) {
       return departRepository.save(depart);
    }

    @Override
    public List<TreeView> treeView() {

        List<Depart> departs = departRepository.findAll();

        return nodes(departs,new Depart());
    }

    public List<TreeView> nodes(List<Depart> departs,Depart depar){

        if(depar.getId() == null){
            for (Depart depart: departs){
                if(depart.getAnode() == 0){
                    TreeView treeView = new TreeView();
                    treeView.setName(depart.getDptname());
                    treeViews.add(treeView);
                    List<Depart> departs1 = new ArrayList<>();
                    for(Depart depart1: departs){
                        if(depart.getCnode() == depart1.getAnode()){
                            departs1.add(depart1);
                        }
                    }
                    if(departs1 != null || departs1.size() != 0){
                         nodes(departs1,depart);
                    }
                }
            }
        }else{

            System.out.println(depar.getDptname()+"===");

            for (Depart departe : departs){
                System.out.println(departe.getDptname());
            }
            System.out.println("======================");

            for(TreeView t : treeViews){
                List<TreeView> viewList = new ArrayList<>();
                for (Depart d : departs){
                    if(depar.getLnode()+1 == d.getLnode() && t.getName() == depar.getDptname()){
                        TreeView view = new TreeView();
                        view.setName(d.getDptname());
                        viewList.add(view);
                    }
                }
                if(viewList.size() > 0){
                    t.setChildren(viewList);
                }
            }

            List<String> dname = new ArrayList<>();
            for(Depart dd : departs){
                if(dd.getLnode() == 3){
                    for(Depart ddd : departs){
                        if(ddd.getCnode() ==dd.getFnode() && ddd.getDptname() != dd.getDptname()){
                            dname.add(ddd.getDptname());
                        }
                    }
                }
            }

            if(dname.size() > 0){
                for(TreeView t : treeViews){
                    if(t.getName() == depar.getDptname()){
                        for(int i = 0 ; i < t.getChildren().size() ; i++) {
                            List<TreeView> treeViews = new ArrayList<>();
                            for (String s : dname ){
                                if(s == t.getChildren().get(i).getName()){
                                    TreeView treeView = new TreeView();
                                    for(Depart d : departs ){
                                        if(d.getLnode() == 3){
                                            treeView.setName(d.getDptname());
                                            treeViews.add(treeView);
                                        }
                                    }
                                }
                            }
                            if(treeViews.size() > 0){
                                t.getChildren().get(i).setChildren(treeViews);
                            }
                        }
                    }
                }
            }

        }
        return treeViews;
    }

    @Override
    public List<Depart> selectAll() {
        return departRepository.findAll();
    }
}
