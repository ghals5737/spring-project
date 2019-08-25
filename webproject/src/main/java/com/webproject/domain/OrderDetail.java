package com.webproject.domain;

public class OrderDetail{

    private int orderDetailsNum;
    private String orderId;
    private int pdNum;
    private int cartStock;

    public int getOrderDetailsNum() {
        return this.orderDetailsNum;
    }
    public void setOrderDetailsNum(int orderDetailsNum) {
        this.orderDetailsNum = orderDetailsNum;
    }


    public String getOrderId() {
    	return this.orderId;
    }
    public void setOrderId(String orderId) {
    	this.orderId = orderId;
    }


    public int getPdNum() {
    	return this.pdNum;
    }
    public void setPdNum(int pdNum) {
    	this.pdNum = pdNum;
    }


    public int getCartStock() {
    	return this.cartStock;
    }
    public void setCartStock(int cartStock) {
    	this.cartStock = cartStock;
    }


}