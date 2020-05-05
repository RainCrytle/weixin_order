package weixin.order.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;
import weixin.order.dataobject.OrderMaster;
import weixin.order.dto.OrderDTO;
import weixin.order.service.BaseOrderService;
import weixin.order.service.PushMessageService;

import static org.junit.Assert.*;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {
    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private BaseOrderService orderService;

    @Test
    public void pushMessageByOrderStatus() {
        OrderDTO orderDTO = orderService.findOne("1587889666221452563");
        pushMessageService.pushMessageByOrderStatus(orderDTO);
    }
}