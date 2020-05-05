package weixin.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import weixin.order.config.ProjectUrlConfig;
import weixin.order.constant.CookieConstant;
import weixin.order.constant.RedisConstant;
import weixin.order.dataobject.SellerInfo;
import weixin.order.enums.ResultEnum;
import weixin.order.service.BaseSellerUserService;
import weixin.order.utils.CookieUtil;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@Slf4j
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private BaseSellerUserService sellerUserService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openId") String openId, Map<String, Object> map, HttpServletResponse response) {
        SellerInfo sellerInfo = sellerUserService.findByOpenId(openId);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.保存到redis
        String token = UUID.randomUUID().toString();
        redisTemplate.boundValueOps(String.format(RedisConstant.TOKEN_PREFIX, token)).set(openId, RedisConstant.expire, TimeUnit.SECONDS);
        //3.保存到cookie
        CookieUtil.saveCookie(response, CookieConstant.TOKEN, token, RedisConstant.expire);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request, Map<String, Object> map) {

        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //1.从redis中删除
            redisTemplate.delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            log.info("[cookie] result={}", String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //2.删除cookie
            CookieUtil.saveCookie(response, CookieConstant.TOKEN, null, 0);

        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
