package com.atguigu.gmall.usermanage.service.impl;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.usermanage.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    /**
     * 查询符合等值条件的用户
     * @param userInfo
     * @return
     */
    @Override
    public List<UserInfo> selectUserList(UserInfo userInfo) {

        return userInfoMapper.select(userInfo);
    }

    /**
     * 模糊查询 例如根据姓名字母进行查询
     * @param userInfo
     * @return
     */
    @Override
    public List<UserInfo> selectUserListByLike(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name","%"+userInfo.getName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    /**
     * 根据主键查询用户
     * @param id
     * @return
     */
    @Override
    public UserInfo selectUserById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据条件查询一个用户
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo selectOneUser(UserInfo userInfo) {
        return userInfoMapper.selectOne(userInfo);
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    /**
     * 根据非主键，进行修改
     * @param userInfo
     */
    @Override
    public void updUser(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    /**
     * 根据主键修改
     * @param userInfo
     */
    @Override
    public void updUserById(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

    }

    /**
     * 根据主键删除用户
     * @param id
     */
    @Override
    public void deleteById(String id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据匹配属性删除
     * @param userInfo
     */
    @Override
    public void deleteUser(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }

    /**
     * 根据主键范围删除
     * @param begin
     * @param end
     */
    @Override
    public void deleteUsers(String begin,String end) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andBetween("id",begin,end);
        userInfoMapper.deleteByExample(example);
    }


}
