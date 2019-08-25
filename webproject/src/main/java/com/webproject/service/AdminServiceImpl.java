package com.webproject.service;

import java.util.List;

import com.webproject.domain.Category;
import com.webproject.domain.Order;
import com.webproject.domain.OrderDetail;
import com.webproject.domain.OrderList;
import com.webproject.domain.Product;
import com.webproject.domain.ProductView;
import com.webproject.domain.ReplyList;
import com.webproject.mapper.AdminMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    private AdminMapper mapper;

	@Override
	public List<Category> category() throws Exception {
		return mapper.category();
    }

    @Override
    public void register(Product product) throws Exception {
        mapper.register(product);
	}

    @Override
    public List<ProductView> productlist() throws Exception {
        return mapper.productlist();
    }

    @Override
    public ProductView getProductView(int pdNum) throws Exception {
        return mapper.getProductView(pdNum);
    }
    @Override
    public void productModify(Product product)throws Exception{
        mapper.productModify(product);
    }

    @Override
    public void productDelete(int pdNum) throws Exception {
       mapper.productDelete(pdNum);
    }

    @Override
    public List<Order> orderList() throws Exception {
        return mapper.orderList();
    }

    @Override
    public List<OrderList> orderView(String orderId) throws Exception {
        return mapper.orderView(orderId);
    }

    @Override
    public void delivery(Order order) throws Exception {
       mapper.delivery(order);
    }

    @Override
    public void changeStock(Product product) throws Exception {
        mapper.changeStock(product);
    }

    @Override
    public List<OrderDetail> getOrderDetails(Order order) throws Exception {
        return mapper.getOrderDetails(order);
    }

    @Override
    public List<ReplyList> allReply() throws Exception {
        return mapper.allReply();
    }

    @Override
    public void deleteReply(int repNum) throws Exception {
        mapper.deleteReply(repNum);
	}
    
}

