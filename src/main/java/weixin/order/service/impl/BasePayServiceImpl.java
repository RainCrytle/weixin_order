package weixin.order.service.impl;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.enums.BestPayResultEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.order.config.WechatPayConfig;
import weixin.order.dto.OrderDTO;
import weixin.order.enums.PayStatusEnum;
import weixin.order.service.BasePayService;
import weixin.order.utils.JsonUtil;

import java.lang.management.LockInfo;
import java.math.BigDecimal;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/27
 */
@Service
@Slf4j
public class BasePayServiceImpl implements BasePayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        payRequest.setOrderId(orderDTO.getOrderId());
        log.info("[微信支付 payRequest={}]", JsonUtil.toJson(payRequest));
        PayResponse response = bestPayService.pay(payRequest);


        log.info("[微信支付 response={}]",JsonUtil.toJson(response));
    }
}
