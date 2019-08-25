package com.webproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webproject.domain.User;
import com.webproject.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user")
public class UserController{

      private static final Logger logger=LoggerFactory.getLogger(UserController.class);
      
      @Autowired
      private UserService service;
      
     // @Autowired
     // private PasswordEncoder passEncoder;    
      
      @RequestMapping(value="/signup", method = RequestMethod.GET)
      public void getSignup()throws Exception{
          logger.info("get signup");
      }
      // 회원 가입 post
     @RequestMapping(value = "/signup", method = RequestMethod.POST)
     public String postSignup(User user) throws Exception {
        logger.info("post signup");
        
       // String inputPass = user.getUserPass();
       // String pass = passEncoder.encode(inputPass);
      //  user.setUserPass(pass);            
        service.signup(user);

        return "redirect:/";
     }

     @RequestMapping(value ="/signin", method=RequestMethod.GET)
     public void getSignin()throws Exception{
         logger.info("get signin");
     }

     @RequestMapping(value = "/signin",method=RequestMethod.POST)
     public String postSignin(User user,HttpServletRequest req,RedirectAttributes rttr)throws Exception{
         logger.info("post signin");
         
         User login=service.signin(user);
         HttpSession session=req.getSession();
        
         if(login !=null&& user.getUserPass().compareTo(login.getUserPass())==0){
             session.setAttribute("user", login);
         }else{
             session.setAttribute("user", null);
             rttr.addFlashAttribute("msg",false);
             return "redirect:/user/signin";
         }
         return "redirect:/";
     }

     @RequestMapping(value = "/signout", method=RequestMethod.GET)
     public String signout(HttpSession session)throws Exception{
         logger.info("get logout");

         service.signout(session);

         return "redirect:/";
     }
}