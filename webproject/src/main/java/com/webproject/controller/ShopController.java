package com.webproject.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.webproject.domain.Cart;
import com.webproject.domain.CartList;
import com.webproject.domain.Order;
import com.webproject.domain.OrderDetail;
import com.webproject.domain.OrderList;
import com.webproject.domain.ProductView;
import com.webproject.domain.Reply;
import com.webproject.domain.ReplyList;
import com.webproject.domain.User;
import com.webproject.service.AdminService;
import com.webproject.service.ShopService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/shop")
public class ShopController{

    private static final Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    ShopService service;
    @Autowired
    AdminService service_admin;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void getList(@RequestParam("c") String cateCode,
         @RequestParam("R") String cateCodeRef, Model model) throws Exception {
            logger.info("get llist");
            
            List<ProductView> list = null;
            if(cateCodeRef.compareTo("0")==0){
                list = service.list1(cateCode,cateCode);
            }else{
                list = service.list2(cateCode);
            }
            
            
            model.addAttribute("list", list);
     
    }

   @GetMapping("/view")
   public void getView(@RequestParam("n")int pdNum,Model model)throws Exception {
      logger.info("get view");

      ProductView view=service_admin.getProductView(pdNum);
      model.addAttribute("view", view);
      /*
      List<ReplyList> reply=service.replyList(pdNum);
      model.addAttribute("reply", reply);*/
   }
   
   @ResponseBody
   @PostMapping("/view/registReply")
   public void registReply(Reply reply,HttpSession session)throws Exception{
        
          logger.info("regist reply");
          
          User user=(User)session.getAttribute("user");
          reply.setUserId(user.getUserId());
          //reply.setPdNum(pdNum);

          service.registReply(reply);       
   }

   @ResponseBody
   @GetMapping("/view/replyList")
   public List<ReplyList> getReplyList(@RequestParam("n") int pdNum)throws Exception{

        logger.info("get reply list");

        List<ReplyList> reply=service.replyList(pdNum);

        return reply;
   }
   
   // 상품 소감(댓글) 삭제
    @ResponseBody
    @PostMapping("/view/deleteReply")
    public int getReplyList(int repNum,HttpSession session) throws Exception {
        logger.info("post delete reply");

        int result = 0;
        
        User user = (User)session.getAttribute("user");
       // int repNum=reply.getRepNum();
        
        String userId = service.idCheck(repNum);
        
        if(user.getUserId().equals(userId)) {          
            service.deleteReply(repNum);            
            result = 1;
        }
    
         return result; 
    }
    // 상품 소감(댓글) 수정
    @ResponseBody
    @RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
    public int modifyReply(Reply reply, HttpSession session) throws Exception {
        logger.info("modify reply");
        
        int result = 0;
        
        User user = (User)session.getAttribute("user");
        String userId = service.idCheck(reply.getRepNum());
        
        if(user.getUserId().equals(userId)) {
        
            reply.setUserId(user.getUserId());
            service.modifyReply(reply);
            result = 1;
        }
        
        return result;
    }
    
    @ResponseBody
    @PostMapping("/view/addCart")
    public int addCart(Cart cart,HttpSession session)throws Exception{

        int result=0;

        User user=(User)session.getAttribute("user");
        
        if(user!=null){
            cart.setUserId(user.getUserId());
            service.addCart(cart);
            result=1;
        }
        
        return result;
    }

        // 카트 목록
    @GetMapping("/cartList")
    public void getCartList(HttpSession session, Model model) throws Exception {
        logger.info("get cart list");
        
        User user = (User)session.getAttribute("user");
        String userId = user.getUserId();
        
        List<CartList> cartList = service.cartList(userId);
        
        model.addAttribute("cartList", cartList);
    
    }

    @ResponseBody
    @PostMapping("/deleteCart")
    public int deleteCart(HttpSession session,@RequestParam("chbox[]")List<String> chArr,Cart cart)throws Exception {
        
        logger.info("delete cart");

        User user=(User)session.getAttribute("user");
        String userId=user.getUserId();

        int result=0;
        int cartNum=0;
        
        if(user!=null){
            cart.setUserId(userId);

            for(String i:chArr){
                cartNum=Integer.parseInt(i);
                cart.setCartNum(cartNum);
                service.deleteCart(cart);
            }
            result=1;
        }
        return result;
    }
    
    @PostMapping("/cartList")
    public String order(HttpSession session,Order order,OrderDetail orderDetail)throws Exception{
        logger.info("order");

        User user=(User)session.getAttribute("user");
        String userId=user.getUserId();
        String orderId=UUID.randomUUID().toString();
        
       // order.setAmount(Integer.parseInt(amount));
        order.setOrderId(orderId);
        order.setUserId(userId);

        service.orderInfo(order);

        orderDetail.setOrderId(orderId);
        service.orderInfo_Details(orderDetail);

        service.cartAllDelete(userId);

        return "redirect:/shop/orderList";
    }

    @GetMapping("/orderList")
    public void getOrderList(HttpSession session,Order order, Model model)throws Exception{
        logger.info("get order list");

        User user=(User)session.getAttribute("user");
        String userId=user.getUserId();

        order.setUserId(userId);

        List<Order> orderList=service.orderList(order);

        model.addAttribute("orderList", orderList);
    }

    @GetMapping("/orderView")
    public void getOrderList(HttpSession session,@RequestParam("n")String orderId,Model model)throws Exception{

        logger.info("get order view");

        User user=(User)session.getAttribute("user");
        String userId=user.getUserId();
       

        List<OrderList> orderView=service.orderView(userId,orderId);

        model.addAttribute("orderView", orderView); 
    }

}