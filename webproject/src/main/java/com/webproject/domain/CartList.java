package com.webproject.domain;

import java.util.Date;

public class CartList {

    private int cartNum;
    private String userId;
    private int pdNum;
    private int cartStock;
    private Date addDate;

   // private int num;
    private String pdName;
    private int pdPrice;
    private String pdThumbImg;

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


    public String getPdName() {
    	return this.pdName;
    }
    public void setPdName(String pdName) {
    	this.pdName = pdName;
    }


    public int getPdPrice() {
    	return this.pdPrice;
    }
    public void setPdPrice(int pdPrice) {
    	this.pdPrice = pdPrice;
    }


    public String getPdThumbImg() {
    	return this.pdThumbImg;
    }
    public void setPdThumbImg(String pdThumbImg) {
    	this.pdThumbImg = pdThumbImg;
    }

}