package com.webproject.domain;

import java.util.Date;


public class User{
   private String userId;
   private String userPass;
   private String userName;
   private String userPhon;
   private String userAddr1;
   private String userAddr2;
   private String userAddr3;
   private Date regDate;
   private int verify;

   public String getUserId() {
   	return this.userId;
   }
   public void setUserId(String userId) {
   	this.userId = userId;
   }


   public String getUserPass() {
   	return this.userPass;
   }
   public void setUserPass(String userPass) {
   	this.userPass = userPass;
   }


   public String getUserName() {
   	return this.userName;
   }
   public void setUserName(String userName) {
   	this.userName = userName;
   }


   public String getUserPhon() {
   	return this.userPhon;
   }
   public void setUserPhon(String userPhon) {
   	this.userPhon = userPhon;
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


   public Date getRegDate() {
   	return this.regDate;
   }
   public void setRegDate(Date regDate) {
   	this.regDate = regDate;
   }


   public int getVerify() {
   	return this.verify;
   }
   public void setVerify(int verify) {
   	this.verify = verify;
   }

}