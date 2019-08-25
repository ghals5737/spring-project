package com.webproject.domain;

public class Category{
    private String cateName;
    private String cateCode;
    private String cateCodeRef;


public String getCateName() {
	return this.cateName;
}
public void setCateName(String cateName) {
	this.cateName = cateName;
}


    public String getCateCode() {
    	return this.cateCode;
    }
    public void setCateCode(String cateCode) {
    	this.cateCode = cateCode;
    }


    public String getCateCodeRef() {
    	return this.cateCodeRef;
    }
    public void setCateCodeRef(String cateCodeRef) {
    	this.cateCodeRef = cateCodeRef;
    }

}