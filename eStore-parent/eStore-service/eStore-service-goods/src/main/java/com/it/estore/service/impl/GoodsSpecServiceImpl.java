package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.CategoryMapper;
import com.it.estore.dao.GoodsSpecMapper;
import com.it.estore.goods.vo.CategoryVO;
import com.it.estore.goods.vo.GoodsSpecVO;
import com.it.estore.service.GoodsSpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSpecServiceImpl implements GoodsSpecService {

    @Resource
    private GoodsSpecMapper goodsSpecMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<GoodsSpecVO> findByCategory(Long categoryId) {
        CategoryVO categoryVO = categoryMapper.selectByPrimaryKey(categoryId);
        GoodsSpecVO specVO = new GoodsSpecVO();
        specVO.setTemplateId(categoryVO.getTemplateId());
        return goodsSpecMapper.select(specVO);
    }

    @Override
    public void add(GoodsSpecVO goodsSpecVO) {
        goodsSpecMapper.insertSelective(goodsSpecVO);
    }

    @Override
    public void update(GoodsSpecVO goodsSpecVO) {
        goodsSpecMapper.updateByPrimaryKeySelective(goodsSpecVO);
    }

    @Override
    public void delete(Long id) {
        goodsSpecMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsSpecVO> findAll() {
        return goodsSpecMapper.selectAll();
    }

    @Override
    public GoodsSpecVO findOneById(Long id) {
        return goodsSpecMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GoodsSpecVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<GoodsSpecVO> goodsSpecVOS = goodsSpecMapper.selectAll();
        return new PageInfo<>(goodsSpecVOS);
    }

    @Override
    public PageInfo<GoodsSpecVO> findPage(GoodsSpecVO goodsSpecVO, Integer page, Integer size) {
        return null;
    }
}
