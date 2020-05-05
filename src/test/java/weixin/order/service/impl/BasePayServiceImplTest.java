package weixin.order.service.impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import weixin.order.config.WechatPayConfig;
import weixin.order.dto.OrderDTO;
import weixin.order.service.BaseOrderService;
import weixin.order.service.BasePayService;

import static org.junit.Assert.*;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/27
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BasePayServiceImplTest {

    @Autowired
    private BasePayService basePayService;
    @Autowired
    private BaseOrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1587889666221452563");
        basePayService.create(orderDTO);
    }
}