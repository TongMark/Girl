package com.tfr.controllers;

import com.tfr.dto.Girl;
import com.tfr.dto.Result;
import com.tfr.service.IGirlService;
import com.tfr.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by TFR on 2017/7/17.
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private IGirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlService.findAllgirls();
    }

    @PostMapping(value = "/add")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        logger.info(girl.getCupSize());
        if (bindingResult.hasErrors()){
            return null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlService.addGirl(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id){
        return girlService.findOneGirl(id);
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }


}
