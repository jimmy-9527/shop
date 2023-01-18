package com.atguigu.gulimall.cart.interceptor;

import com.atguigu.common.vo.MemberResponseVo;
import com.atguigu.gulimall.cart.to.UserInfoTo;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

import static com.atguigu.common.constant.AuthServerConstant.LOGIN_USER;
import static com.atguigu.common.constant.CartConstant.TEMP_USER_COOKIE_NAME;
import static com.atguigu.common.constant.CartConstant.TEMP_USER_COOKIE_TIMEOUT;

public class CartInterceptor implements HandlerInterceptor {
    public static ThreadLocal<UserInfoTo> toThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        UserInfoTo userInfoTo = new UserInfoTo();
        HttpSession session = request.getSession();
        MemberResponseVo memberResponseVo = (MemberResponseVo) session.getAttribute(LOGIN_USER);

        if (memberResponseVo != null) {
            userInfoTo.setUserId(memberResponseVo.getId());
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals(TEMP_USER_COOKIE_NAME)) {
                    userInfoTo.setUserKey(cookie.getValue());
                    userInfoTo.setTempUser(true);
                }
            }
        }

        if (StringUtils.isEmpty(userInfoTo.getUserKey())) {
            String uuid = UUID.randomUUID().toString();
            userInfoTo.setUserKey(uuid);
        }

        toThreadLocal.set(userInfoTo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        UserInfoTo userInfoTo = toThreadLocal.get();
        if (!userInfoTo.getTempUser()) {
            Cookie cookie = new Cookie(TEMP_USER_COOKIE_NAME, userInfoTo.getUserKey());
            cookie.setDomain("gulimall.com");
            cookie.setMaxAge(TEMP_USER_COOKIE_TIMEOUT);
            response.addCookie(cookie);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) {
    }
}
