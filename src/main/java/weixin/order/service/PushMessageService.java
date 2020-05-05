package weixin.order.service;

import weixin.order.dto.OrderDTO;

/**
 * @author Rain
 * @version 1.0
 * @description 消息推送
 * @date 2020/4/30
 */
public interface PushMessageService {
    /*更改订单推送消息*/
    void pushMessageByOrderStatus(OrderDTO orderDTO);
}
