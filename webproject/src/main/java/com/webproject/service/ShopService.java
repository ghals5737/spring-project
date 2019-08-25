package com.webproject.service;

import java.util.List;

import com.webproject.domain.Cart;
import com.webproject.domain.CartList;
import com.webproject.domain.Order;
import com.webproject.domain.OrderDetail;
import com.webproject.domain.OrderList;
import com.webproject.domain.ProductView;
import com.webproject.domain.Reply;
import com.webproject.domain.ReplyList;

public interface ShopService {
    public List<ProductView> list1(String cateCode,String cateCodeRef) throws Exception;
    public List<ProductView> list2(String cateCode) throws Exception;
    public void registReply(Reply reply)throws Exception;  
    public List<ReplyList> replyList(int pdNum)throws Exception;
    public void deleteReply(int repNum)throws Exception;
    public String idCheck(int repNum)throws Exception;
    public void modifyReply(Reply reply)throws Exception;
    public void addCart(Cart cart)throws Exception;  
    public List<CartList> cartList(String userId)throws Exception;
    public void deleteCart(Cart cart)throws Exception;
    public void orderInfo(Order order)throws Exception;
    public void orderInfo_Details(OrderDetail orderDetail)throws Exception;
    public void cartAllDelete(String userId)throws Exception;
    public List<Order> orderList(Order order)throws Exception;
    public List<OrderList> orderView(String userId,String orderId)throws Exception;
}