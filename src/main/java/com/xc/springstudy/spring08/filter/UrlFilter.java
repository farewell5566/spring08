package com.xc.springstudy.spring08.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter (urlPatterns = "/*")
public class UrlFilter implements Filter {


    private final String[] IGNORE_URI={"/index","/account/login","/account/validataAccount","/css/","/js/","/images/"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest reQ = (HttpServletRequest) servletRequest;
        HttpServletResponse reP = (HttpServletResponse) servletResponse;


        //String loginURI = "/login";
        System.out.println(reQ.getRequestURI());

        for (String url : IGNORE_URI){
            if(reQ.getRequestURI().startsWith(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        Object account = reQ.getSession().getAttribute("account");

        if (null == account){
            reP.sendRedirect("/account/login");
            return ;
        }else {
            System.out.println(account.toString());
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----init-----");
        Filter.super.init(filterConfig);

    }
}
