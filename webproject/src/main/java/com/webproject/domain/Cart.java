package com.webproject.domain;

import java.util.Date;

public class Cart{

    private int cartNum;
    private String userId;
    private int pdNum;
    private int cartStock;
    private Date addDate;

    public int getCartNum() {
    	return this.cartNum;
    }
    public void setCartNum(int cartNum) {
    	this.cartNum = cartNum;
    }


    public String getUserId() {
    	return this.userId;
    }
    public void setUserId(String userId) {
    	this.userId = userId;
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


    public Date getAddDate() {
    	return this.addDate;
    }
    public void setAddDate(Date addDate) {
    	this.addDate = addDate;
    }

}