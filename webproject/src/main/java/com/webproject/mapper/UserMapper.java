package com.webproject.mapper;

import javax.servlet.http.HttpSession;

import com.webproject.domain.User;

public interface UserMapper {
    public void signup(User user)throws Exception;
    public User signin(User user)throws Exception;
    public void signout(HttpSession session)throws Exception;
}