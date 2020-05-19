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


    int x = 2;

    public void t2(int x) {
        x += x;
        System.out.println(x);
    }
}

class Test2 {
    public static void main(String[] args) {
        int y=0;
        int x = 10;
        do {
            x--;

            System.out.println("1");
        } while (x < 10);
    }

}