package com.webproject.domain;

import java.util.Date;

public class ProductView{
    private int pdNum;
    private String pdName;
    private String cateCode;
    private int pdPrice;
    private int pdStock;
    private String pdDes;
    private String pdImg;
    private Date pdDate;

    private String cateCodeRef;
    private String cateName;
    private String pdThumbImg;

public String getPdThumbImg() {
	return this.pdThumbImg;
}
public void setPdThumbImg(String pdThumbImg) {
	this.pdThumbImg = pdThumbImg;
}

 public String getCateCodeRef() {
 	return this.cateCodeRef;
 }
 public void setCateCodeRef(String cateCodeRef) {
 	this.cateCodeRef = cateCodeRef;
 }


    public String getCateName() {
    	return this.cateName;
    }
    public void setCateName(String cateName) {
    	this.cateName = cateName;
    }



    public int getPdNum() {
    	return this.pdNum;
    }
    public void setPdNum(int pdNum) {
    	this.pdNum = pdNum;
    }


    public String getPdName() {
    	return this.pdName;
    }
    public void setPdName(String pdName) {
    	this.pdName = pdName;
    }


    public String getCateCode() {
    	return this.cateCode;
    }
    public void setCateCode(String cateCode) {
    	this.cateCode = cateCode;
    }


    public int getPdPrice() {
    	return this.pdPrice;
    }
    public void setPdPrice(int pdPrice) {
    	this.pdPrice = pdPrice;
    }


    public int getPdStock() {
    	return this.pdStock;
    }
    public void setPdStock(int pdStock) {
    	this.pdStock = pdStock;
    }


    public String getPdDes() {
    	return this.pdDes;
    }
    public void setPdDes(String pdDes) {
    	this.pdDes = pdDes;
    }


    public String getPdImg() {
    	return this.pdImg;
    }
    public void setPdImg(String pdImg) {
    	this.pdImg = pdImg;
    }


    public Date getPdDate() {
    	return this.pdDate;
    }
    public void setPdDate(Date pdDate) {
    	this.pdDate = pdDate;
    }

    
}