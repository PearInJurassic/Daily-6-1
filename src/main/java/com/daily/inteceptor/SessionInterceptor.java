package com.daily.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            //System.out.println(session.getAttribute("userId").toString());
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }
}
