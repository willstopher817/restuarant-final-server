package com.mercury.final_server.interceptor;

// log whoever accessed specific APIs

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WhoAccessedInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(request.getRemoteAddr() + "access API:" + request.getRequestURI());
        // 192.168.1.20 accessed API: /samples
        return super.preHandle(request, response, handler);
    }

    // postHandle: do something after response is sent by controller
}
