package com.tfr.exception;

import com.tfr.enums.ResultEnum;

/**
 * Created by TFR on 2017/8/10.
 * 自定义异常
 * 继承RuntimeException，spring有事务回滚，继承Exception则没有
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
