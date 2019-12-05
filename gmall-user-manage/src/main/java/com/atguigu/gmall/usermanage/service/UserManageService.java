package com.atguigu.gmall.usermanage.service;

import com.atguigu.gmall.usermanage.bean.UserInfo;

import java.util.List;

public interface UserManageService {

    List<UserInfo> findAll();

    List<UserInfo> selectUserList(UserInfo userInfo);

    List<UserInfo> selectUserListByLike(UserInfo userInfo);

    UserInfo selectUserById(String id);

    UserInfo selectOneUser(UserInfo userInfo);

    void addUser(UserInfo userInfo);


    void updUser(UserInfo userInfo);

    void updUserById(UserInfo userInfo);

    void deleteById(String id);

    void deleteUser(UserInfo userInfo);

    void deleteUsers(String begin,String end);

}
