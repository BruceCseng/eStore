package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.TemplateMapper;
import com.it.estore.goods.vo.TemplateVO;
import com.it.estore.service.TemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public void add(TemplateVO templateVO) {
        templateMapper.insertSelective(templateVO);
    }

    @Override
    public void delete(Long id) {
        templateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(TemplateVO templateVO) {
        templateMapper.updateByPrimaryKeySelective(templateVO);
    }

    @Override
    public TemplateVO findById(Long id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TemplateVO> findAll() {
        return templateMapper.selectAll();
    }

    @Override
    public List<TemplateVO> findList(TemplateVO templateVO) {
        return null;
    }

    @Override
    public PageInfo<TemplateVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<TemplateVO> templateVOS = templateMapper.selectAll();
        return new PageInfo<>(templateVOS);
    }

    @Override
    public PageInfo<TemplateVO> findPage(TemplateVO templateVO, Integer page, Integer size) {
        return null;
    }
}
