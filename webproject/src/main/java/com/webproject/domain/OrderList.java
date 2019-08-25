package com.webproject.domain;

import java.util.Date;

public class OrderList{

    private String orderId;
    private String userId;
    private String orderRec;
    private String userAddr1;
    private String userAddr2;
    private String userAddr3;
    private String orderPhon;
    private int amount;
    private Date orderDate;

    private int orderDetailsNum;
    private int pdNum;
    private int cartStock;

    private String pdName;
    private String pdThumbImg;
    private int pdPrice;

   public String getOrderId() {
   	return this.orderId;
   }
   public void setOrderId(String orderId) {
   	this.orderId = orderId;
   }


    public String getUserId() {
    	return this.userId;
    }
    public void setUserId(String userId) {
    	this.userId = userId;
    }


    public String getOrderRec() {
    	return this.orderRec;
    }
    public void setOrderRec(String orderRec) {
    	this.orderRec = orderRec;
    }


    public String getUserAddr1() {
    	return this.userAddr1;
    }
    public void setUserAddr1(String userAddr1) {
    	this.userAddr1 = userAddr1;
    }


    public String getUserAddr2() {
    	return this.userAddr2;
    }
    public void setUserAddr2(String userAddr2) {
    	this.userAddr2 = userAddr2;
    }


    public String getUserAddr3() {
    	return this.userAddr3;
    }
    public void setUserAddr3(String userAddr3) {
    	this.userAddr3 = userAddr3;
    }


    public String getOrderPhon() {
    	return this.orderPhon;
    }
    public void setOrderPhon(String orderPhon) {
    	this.orderPhon = orderPhon;
    }


    public int getAmount() {
    	return this.amount;
    }
    public void setAmount(int amount) {
    	this.amount = amount;
    }


    public Date getOrderDate() {
    	return this.orderDate;
    }
    public void setOrderDate(Date orderDate) {
    	this.orderDate = orderDate;
    }


    public int getOrderDetailsNum() {
    	return this.orderDetailsNum;
    }
    public void setOrderDetailsNum(int orderDetailsNum) {
    	this.orderDetailsNum = orderDetailsNum;
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


    public String getPdName() {
    	return this.pdName;
    }
    public void setPdName(String pdName) {
    	this.pdName = pdName;
    }


    public String getPdThumbImg() {
    	return this.pdThumbImg;
    }
    public void setPdThumbImg(String pdThumbImg) {
    	this.pdThumbImg = pdThumbImg;
    }


    public int getPdPrice() {
    	return this.pdPrice;
    }
    public void setPdPrice(int pdPrice) {
    	this.pdPrice = pdPrice;
    }

}