package com.webproject.domain;

import java.util.Date;

public class ReplyList{

    private int pdNum;
    private String userId;
    private int repNum;
    private String repCon;
    private Date repDate;
    private String userName;

public String getUserName() {
	return this.userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}


  public int getPdNum() {
  	return this.pdNum;
  }
  public void setPdNum(int pdNum) {
  	this.pdNum = pdNum;
  }


    public String getUserId() {
    	return this.userId;
    }
    public void setUserId(String userId) {
    	this.userId = userId;
    }


    public int getRepNum() {
    	return this.repNum;
    }
    public void setRepNum(int repNum) {
    	this.repNum = repNum;
    }


    public String getRepCon() {
    	return this.repCon;
    }
    public void setRepCon(String repCon) {
    	this.repCon = repCon;
    }


    public Date getRepDate() {
    	return this.repDate;
    }
    public void setRepDate(Date repDate) {
    	this.repDate = repDate;
    }


}