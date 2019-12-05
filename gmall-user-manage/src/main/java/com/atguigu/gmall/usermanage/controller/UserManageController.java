package com.atguigu.gmall.usermanage.controller;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManageController {
    @Autowired
    private UserManageService userManageService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        List<UserInfo>  userList = userManageService.findAll();
        return userList;
    }

    /**
     * 根据等值条件查询
     * @return
     */
    @RequestMapping("selectUserList")
    public List<UserInfo> selectUserList(UserInfo userInfo){
        List<UserInfo>  userList = userManageService.selectUserList(userInfo);
        return userList;
    }

    /**
     * 根据name 模糊查询
     * @param userInfo
     * @return
     */
    @RequestMapping("selectUserListByLike")
    public List<UserInfo> selectUserListByLike(UserInfo userInfo){
        List<UserInfo>  userList = userManageService.selectUserListByLike(userInfo);
        return userList;
    }

    /**
     * 根据主键查询一个用户
     * @param id
     * @return
     */
    @RequestMapping("selectUserById")
    public UserInfo selectUserById(String id){
        UserInfo user= userManageService.selectUserById(id);
        return user;
    }

    /**
     * 根据条件查询一个用户
     * @param userInfo
     * @return
     */
    @RequestMapping("selectOneUser")
    public UserInfo selectOneUser(UserInfo userInfo){
        UserInfo user= userManageService.selectOneUser(userInfo);
        return user;
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @RequestMapping("addUser")
    public void addUser(UserInfo userInfo){
        userManageService.addUser(userInfo);
    }

    /**
     * 根据非主键，进行修改
     * @param userInfo
     */
    @RequestMapping("updUser")
    public void updUser(UserInfo userInfo){
        userManageService.updUser(userInfo);
    }

    /**
     * 根据主键修改
     * @param userInfo
     */
    @RequestMapping("updUserById")
    public void updUserById(UserInfo userInfo){
        userManageService.updUserById(userInfo);
    }

    /**
     * 根据主键删除
     * @param id
     */
    @RequestMapping("deleteById")
    public void deleteById(String id){
        userManageService.deleteById(id);
    }

    /**
     * 根据属性删除
     * @param userInfo
     */
    @RequestMapping("deleteUser")
    public void deleteUser(UserInfo userInfo){
        userManageService.deleteUser(userInfo);
    }

    /**
     * 按范围匹配删除
     * @param userInfo
     */
    @RequestMapping("deleteUsers")
    public void deleteUsers(String begin,String end){
        userManageService.deleteUsers(begin,end);
    }

}
