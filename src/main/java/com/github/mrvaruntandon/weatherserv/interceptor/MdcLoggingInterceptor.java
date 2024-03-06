package com.github.mrvaruntandon.weatherserv.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

import static com.github.mrvaruntandon.weatherserv.constants.WeatherservConstants.TRANSACTION_ID;

@Component
public class MdcLoggingInterceptor implements HandlerInterceptor {

    public static final String TRANSACTION_ID_PREFIX = TRANSACTION_ID + "=";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String transactionId = request.getHeader(TRANSACTION_ID);
        if(transactionId != null){
            MDC.put(TRANSACTION_ID, TRANSACTION_ID_PREFIX + transactionId);
        } else {
            MDC.put(TRANSACTION_ID, TRANSACTION_ID_PREFIX + UUID.randomUUID());
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(TRANSACTION_ID);
    }
}

