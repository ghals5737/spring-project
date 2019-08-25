package com.webproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webproject.domain.User;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object obj)throws Exception{
        
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");

        if(user==null){
            res.sendRedirect("/user/signin");
            return false;
        }
        if(user.getVerify()!=9){
            res.sendRedirect("/");
            return false;
        }
        
        return true;
    }

}