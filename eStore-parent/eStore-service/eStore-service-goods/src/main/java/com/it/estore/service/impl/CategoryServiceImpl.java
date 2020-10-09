package com.it.estore.service.impl;

import com.github.pagehelper.PageInfo;
import com.it.estore.dao.CategoryMapper;
import com.it.estore.goods.vo.CategoryVO;
import com.it.estore.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> findByParentId(Long pid) {
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setParentId(pid);
        return categoryMapper.select(categoryVO);
    }

    @Override
    public void add(CategoryVO categoryVO) {
        categoryMapper.insertSelective(categoryVO);
    }

    @Override
    public void update(CategoryVO categoryVO) {
        categoryMapper.updateByPrimaryKeySelective(categoryVO);
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryVO> findAll() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAll();
        return categoryVOS;
    }

    @Override
    public CategoryVO findOneById(Long id) {

        return null;
    }

    @Override
    public PageInfo<CategoryVO> findPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public PageInfo<CategoryVO> findPage(CategoryVO categoryVO, Integer page, Integer size) {
        return null;
    }
}
