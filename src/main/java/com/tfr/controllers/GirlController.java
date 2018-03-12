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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author TFR
 * @date 2017/7/17
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }

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

    @PostMapping(value = "/httpClientPost")
    public Result<Girl> post(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("p") String password){
        String name1 = request.getParameter("name");
        String passWord1 = request.getParameter("p");
        logger.info("name : {} , password : {} ", name, password);
        logger.info("name1 : {} , password1 : {} ", name1, passWord1);
        return ResultUtil.success(girlService.findAllgirls());
    }

    @PostMapping(value = "/girl/ajax")
    public Result<Girl> ajax(HttpServletRequest request ,Girl girl){
        //Integer id1 = id;
        logger.info("ID : {}",girl.getId());

        return ResultUtil.success(true);
    }

}
