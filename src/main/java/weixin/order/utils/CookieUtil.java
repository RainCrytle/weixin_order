package weixin.order.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
public class CookieUtil {

    public static void saveCookie(HttpServletResponse response, String name, String value, Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    //获取cookie
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap != null) {
            if (cookieMap.containsKey(name)) {
                return cookieMap.get(name);
            }
        }

        return null;
    }

    //将cookie封装成maop
    public static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie);
            }
            return map;
        }
        return null;

    }
}
