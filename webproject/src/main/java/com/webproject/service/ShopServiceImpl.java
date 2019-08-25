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
import com.webproject.mapper.ShopMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper mapper;
	
    @Override
    public List<ProductView> list1(String cateCode, String cateCodeRef) throws Exception {
        return mapper.list1(cateCode, cateCodeRef);
    }

    @Override
    public List<ProductView> list2(String cateCode) throws Exception {
        return mapper.list2(cateCode);
    }

    @Override
    public void registReply(Reply reply) throws Exception {
        mapper.registReply(reply);
    }

    @Override
    public List<ReplyList> replyList(int pdNum) throws Exception {
        return mapper.replyList(pdNum);
	}

    @Override
    public String idCheck(int repNum) throws Exception {
        return mapper.idCheck(repNum);
    }

    @Override
    public void deleteReply(int repNum) throws Exception {
              mapper.deleteReply(repNum);
    }

    @Override
    public void modifyReply(Reply reply) throws Exception {
        mapper.modifyReply(reply);
    }

    @Override
    public void addCart(Cart cart) throws Exception {
        mapper.addCart(cart);
    }

    @Override
    public List<CartList> cartList(String userId) throws Exception {
        return mapper.cartList(userId);
	}

    @Override
    public void deleteCart(Cart cart) throws Exception {
        mapper.deleteCart(cart);
    }

    @Override
    public void orderInfo(Order order) throws Exception {
        mapper.orderInfo(order);
    }

    @Override
    public void orderInfo_Details(OrderDetail orderDetail) throws Exception {
		mapper.orderInfo_Details(orderDetail);
	}

    @Override
    public void cartAllDelete(String userId) throws Exception {
        mapper.cartAllDelete(userId);
    }

    @Override
    public List<Order> orderList(Order order) throws Exception {
        return mapper.orderList(order);
    }
   
    @Override
    public List<OrderList> orderView(String userId, String orderId) throws Exception {
        return mapper.orderView(userId, orderId);
    }

}