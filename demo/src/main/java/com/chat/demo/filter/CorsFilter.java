
package com.chat.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class CorsFilter implements Filter {

    private static final List<String>   ALLOWED_ORIGINS = Arrays.asList("http:/localhost:4200");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

      String incom=  req.getHeader("Origin");
         if(ALLOWED_ORIGINS.contains(incom)) {
         res.setHeader("Acccess-Control-Allow-Origin",incom);}
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}

