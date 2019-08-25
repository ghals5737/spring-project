package com.webproject.service;

import java.util.List;

import com.webproject.domain.Category;
import com.webproject.domain.Order;
import com.webproject.domain.OrderDetail;
import com.webproject.domain.OrderList;
import com.webproject.domain.Product;
import com.webproject.domain.ProductView;
import com.webproject.domain.ReplyList;

public interface AdminService {
     public List<Category> category()throws Exception;
     public void register(Product product)throws Exception;
     public List<ProductView> productlist()throws Exception;
     public ProductView getProductView(int pdNum)throws Exception;
     public void productModify(Product product)throws Exception;
     public void productDelete(int pdNum)throws Exception;
     public List<Order> orderList()throws Exception;
     public List<OrderList> orderView(String orderId)throws Exception; 
     public void delivery(Order order)throws Exception;
     public void changeStock(Product product)throws Exception; 
     public List<OrderDetail> getOrderDetails(Order order)throws Exception;
     public List<ReplyList> allReply()throws Exception;
     public void deleteReply(int repNum)throws Exception;      
}