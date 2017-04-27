package com.pingrong.core.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 获取cookie CSESSIONID
 */
public class RequestUtils {
    public static String getCSESSIONID(HttpServletRequest request, HttpServletResponse response){
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0){
            for (Cookie cookie : cookies){
                if ("CSESSIONID".equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        //获取UUID并去除-线
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //创建cookie
        Cookie cookie = new Cookie("CSESSIONID",uuid);
        //设置生命周期 -1关闭浏览器销毁   0  立即销毁  >0 定时销毁
        cookie.setMaxAge(-1);
        //设置路径     cookie在什么路径下存在  /域名在存在
        cookie.setPath("/");
        //设置跨域  a.taobao.com   b.taobao.com  *.taobao.com都会携带cookie
        //cookie.setDomain(".taobao.com");
        //回写创建的cookie
        response.addCookie(cookie);
        return uuid;
    }
}
