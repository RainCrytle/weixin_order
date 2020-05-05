package weixin.order.service;

import com.lly835.bestpay.model.PayResponse;
import weixin.order.dto.OrderDTO;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/27
 */
public interface BasePayService {
   void create(OrderDTO orderDTO);
}
