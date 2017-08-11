package com.tfr.service;

import com.tfr.dto.Girl;

import java.util.List;

/**
 * Created by TFR on 2017/7/17.
 */
public interface IGirlService {

    /**
     * 查询所有女生列表
     * @return
     */
    List<Girl> findAllgirls();

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    Girl addGirl(Girl girl);

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    Girl findOneGirl(Integer id);

    /**
     * 更新
     * @param girl
     * @return
     */
    Girl updateGirl(Girl girl);

    /**
     * 删除
     * @param id
     */
    void deleteGirl(Integer id);

    /**
     * 通过年龄查询女生
     * @param age
     * @return
     */
    List<Girl> girlListByAge(Integer age);

    /**
     * 新增
     * @param girl
     */
    void insertGirl(Girl girl);

    /**
     *
     * @param id
     */
    void getAge(Integer id) throws Exception;


}
