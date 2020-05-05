package weixin.order.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import weixin.order.Exeption.LoginException;
import weixin.order.constant.CookieConstant;
import weixin.order.constant.RedisConstant;
import weixin.order.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(public * weixin.order.controller.Sell*.*(..))" +
            "&&!execution(public * weixin.order.controller.SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //1.现查询cookie
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new LoginException();
        }

        //2.查询redis中有没有登陆对象数据

        String redisStr = (String) redisTemplate.boundValueOps(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue())).get();
        if (StringUtils.isEmpty(redisStr)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new LoginException();
        }
    }
}
