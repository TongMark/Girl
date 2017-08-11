package com.tfr;

import com.tfr.dto.Girl;
import com.tfr.service.IGirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by TFR on 2017/8/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IGirlServiceTest {

    @Autowired
    private IGirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOneGirl(1);
        Assert.assertEquals(new Integer(9),girl.getAge());
    }
}
