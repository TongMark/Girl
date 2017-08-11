package com.tfr.controllers;

import com.tfr.dto.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TFR on 2017/7/13.
 */
@RestController
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;*/

    @Autowired
    private GirlProperties girlProperties;

    //url:localhost:8081/hello/1
    //@RequestMapping(value = {"/hello/{id}"},method = RequestMethod.POST)
    @PostMapping(value = "/hello/{id}")
    public String say(@PathVariable(value = "id") Integer id){
        return "id:"+ id;
    }

    //url:localhost:8081/hi?id=1
    //@RequestMapping(value = "/hi",method = RequestMethod.GET)
    @GetMapping(value = "/hi")
    public String sayP(@RequestParam(value = "id" ,required = false ,defaultValue = "0") Integer id){
        return "id:"+ id;
    }
}
