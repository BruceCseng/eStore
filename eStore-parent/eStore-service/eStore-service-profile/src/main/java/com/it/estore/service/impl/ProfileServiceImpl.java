package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.BlogMapper;
import com.it.estore.dao.ContentMapper;
import com.it.estore.dao.MainMenuMapper;
import com.it.estore.dao.MessageMapper;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.MessageVO;
import com.it.estore.service.ProfileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午9:58
 * @Description: com.it.estore.service.impl
 * @Version: 1.0
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private MainMenuMapper mainMenuMapper;

    @Resource
    private MessageMapper messageMapper;

    @Override
    public ContentVO findContent(ContentVO contentVO) {
        Example example = this.createExample(contentVO);
        return contentMapper.selectOneByExample(example);
    }

    @Override
    public List<ContentVO> findContentList(ContentVO contentVO) {
        Example example = this.createExample(contentVO);
        return contentMapper.selectByExample(example);
    }

    @Override
    public List<MainMenuVO> findAllMainMenu() {
        return mainMenuMapper.selectAll();
    }

    @Override
    public PageInfo<BlogVO> findPage(Integer page, Integer size){
        PageHelper.startPage(page,size);
        List<BlogVO> albumVOS = blogMapper.selectAll();
        return new PageInfo<>(albumVOS);
    }

    @Override
    public void addMessage(MessageVO messageVO) {
        messageMapper.insertSelective(messageVO);
    }

    private Example createExample(ContentVO contentVO) {
        Example example = new Example(ContentVO.class);
        Example.Criteria criteria = example.createCriteria();
        if (contentVO != null) {
            if (!StringUtils.isEmpty(contentVO.getType())) {
                criteria.andEqualTo("type", contentVO.getType());
            }
            if (contentVO.getParentId()!=null) {
                criteria.andEqualTo("parentId", contentVO.getParentId());
            }
            return example;
        }
        return null;
    }
}
