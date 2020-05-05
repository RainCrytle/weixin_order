package weixin.order.controller;

import com.lly835.bestpay.service.BestPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import weixin.order.Exeption.SellException;
import weixin.order.dataobject.OrderMaster;
import weixin.order.dto.OrderDTO;
import weixin.order.enums.ResultEnum;
import weixin.order.service.BaseOrderService;
import weixin.order.service.BasePayService;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/27
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private BaseOrderService orderService;

    @Autowired
    private BasePayService payService;

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam("/orderId") String orderId){

        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.PRODUCT_ORDER_NOT_EXIST);
        }
        //.发起支付
        payService.create(orderDTO);
        ModelAndView modelAndView=new ModelAndView();
        return modelAndView;
    }
}
