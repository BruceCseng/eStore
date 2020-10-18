package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.UserMapper;
import com.it.estore.service.UserService;
import com.it.estore.user.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * User条件+分页查询
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UserVO> findPage(UserVO user, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<UserVO>(userMapper.selectByExample(example));
    }

    /**
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UserVO> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UserVO>(userMapper.selectAll());
    }

    /**
     * User条件查询
     * @param user
     * @return
     */
    @Override
    public List<UserVO> findList(UserVO user){
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(UserVO user){
        Example example= new Example(UserVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 用户名
            if(!StringUtils.isEmpty(user.getUsername())){
                criteria.andLike("username","%"+user.getUsername()+"%");
            }
            // 密码，加密存储
            if(!StringUtils.isEmpty(user.getPassword())){
                criteria.andEqualTo("password",user.getPassword());
            }
            // 注册手机号
            if(!StringUtils.isEmpty(user.getPhone())){
                criteria.andEqualTo("phone",user.getPhone());
            }
            // 注册邮箱
            if(!StringUtils.isEmpty(user.getEmail())){
                criteria.andEqualTo("email",user.getEmail());
            }
            // 创建时间
            if(!StringUtils.isEmpty(user.getCreated())){
                criteria.andEqualTo("created",user.getCreated());
            }
            // 修改时间
            if(!StringUtils.isEmpty(user.getUpdated())){
                criteria.andEqualTo("updated",user.getUpdated());
            }
            // 会员来源：1:PC，2：H5，3：Android，4：IOS
            if(!StringUtils.isEmpty(user.getSourceType())){
                criteria.andEqualTo("sourceType",user.getSourceType());
            }
            // 昵称
            if(!StringUtils.isEmpty(user.getNickName())){
                criteria.andEqualTo("nickName",user.getNickName());
            }
            // 真实姓名
            if(!StringUtils.isEmpty(user.getName())){
                criteria.andLike("name","%"+user.getName()+"%");
            }
            // 使用状态（1正常 0非正常）
            if(!StringUtils.isEmpty(user.getStatus())){
                criteria.andEqualTo("status",user.getStatus());
            }
            // 头像地址
            if(!StringUtils.isEmpty(user.getHeadPic())){
                criteria.andEqualTo("headPic",user.getHeadPic());
            }
            // QQ号码
            if(!StringUtils.isEmpty(user.getQq())){
                criteria.andEqualTo("qq",user.getQq());
            }
            // 手机是否验证 （0否  1是）
            if(!StringUtils.isEmpty(user.getIsMobileCheck())){
                criteria.andEqualTo("isMobileCheck",user.getIsMobileCheck());
            }
            // 邮箱是否检测（0否  1是）
            if(!StringUtils.isEmpty(user.getIsEmailCheck())){
                criteria.andEqualTo("isEmailCheck",user.getIsEmailCheck());
            }
            // 性别，1男，0女
            if(!StringUtils.isEmpty(user.getSex())){
                criteria.andEqualTo("sex",user.getSex());
            }
            // 出生年月日
            if(!StringUtils.isEmpty(user.getBirthday())){
                criteria.andEqualTo("birthday",user.getBirthday());
            }
            // 最后登录时间
            if(!StringUtils.isEmpty(user.getLastLoginTime())){
                criteria.andEqualTo("lastLoginTime",user.getLastLoginTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User
     * @param user
     */
    @Override
    public void update(UserVO user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 增加User
     * @param user
     */
    @Override
    public void add(UserVO user){
        userMapper.insert(user);
    }

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public UserVO findById(String id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询User全部数据
     * @return
     */
    @Override
    public List<UserVO> findAll() {
        return userMapper.selectAll();
    }
}
