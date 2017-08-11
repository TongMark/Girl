package com.tfr.service.impl;

import com.tfr.dto.Girl;
import com.tfr.enums.ResultEnum;
import com.tfr.exception.GirlException;
import com.tfr.repository.GirlRepository;
import com.tfr.service.IGirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TFR on 2017/7/17.
 */
@Service
public class GirlServiceImpl implements IGirlService{

    @Autowired
    private GirlRepository girlRepository;

    @Override
    public List<Girl> findAllgirls() {
        return girlRepository.findAll();
    }

    @Override
    public Girl addGirl(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public Girl findOneGirl(Integer id) {
        return girlRepository.findOne(id);
    }

    @Override
    public Girl updateGirl(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public void deleteGirl(Integer id) {
        girlRepository.delete(id);
    }

    @Override
    public List<Girl> girlListByAge(Integer age) {
        return girlRepository.findByAge(age);
    }

    @Override
    public void insertGirl(Girl girl) {

    }

    @Override
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //code = 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }


    }
}
