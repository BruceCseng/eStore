package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.user.vo.UserVO;

import java.util.List;

public interface UserService {

    /***
     * User多条件分页查询
     * @param user
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserVO> findPage(UserVO user, int page, int size);

    /***
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserVO> findPage(int page, int size);

    /***
     * User多条件搜索方法
     * @param user
     * @return
     */
    List<UserVO> findList(UserVO user);

    /***
     * 删除User
     * @param id
     */
    void delete(String id);

    /***
     * 修改User数据
     * @param user
     */
    void update(UserVO user);

    /***
     * 新增User
     * @param user
     */
    void add(UserVO user);

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    UserVO findById(String id);

    /***
     * 查询所有User
     * @return
     */
    List<UserVO> findAll();
}
