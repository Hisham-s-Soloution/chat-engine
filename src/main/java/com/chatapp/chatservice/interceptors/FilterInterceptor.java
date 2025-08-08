package com.chatapp.chatservice.interceptors;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class FilterInterceptor implements Filter {
    private static final String DEFAULT_LANGUAGE = "en";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        validateHeaderLanguage(httpRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void validateHeaderLanguage(HttpServletRequest request) {
        String local = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if (local == null || local.isBlank()) {
            log.warn("local is empty please add local");
            request.setAttribute(HttpHeaders.ACCEPT_LANGUAGE, DEFAULT_LANGUAGE);
        } else {
            log.info("Our System call with local, {}", local);
        }
    }
}
