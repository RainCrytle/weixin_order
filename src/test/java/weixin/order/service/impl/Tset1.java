package weixin.order.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/5/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Tset1 {
    @Test
    public void t1(){
        String a="abc";
        String b="abc";
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }
}
