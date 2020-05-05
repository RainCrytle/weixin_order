package weixin.order.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import weixin.order.Exeption.LoginException;
import weixin.order.config.ProjectUrlConfig;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;
//
//    @ExceptionHandler(value = LoginException.class)
//    public ModelAndView sellerExceptionHandler() {
//        return new ModelAndView("redirect:"
//                .concat(projectUrlConfig.getWechatOpenAuthorize())
//                .concat("/sell/wechat/qrAuthorize")
//                .concat("?returnUrl=")
//                .concat(projectUrlConfig.getSell())
//                .concat("/sell/seller/login"));
//    }

    @ExceptionHandler(value = LoginException.class)
    public ModelAndView sellerExceptionHandler() {
        return new ModelAndView("redirect: www.baidu.com ");
    }

}
