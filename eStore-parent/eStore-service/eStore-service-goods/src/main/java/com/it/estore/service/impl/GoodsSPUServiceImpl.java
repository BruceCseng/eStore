package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.GoodsSPUMapper;
import com.it.estore.goods.vo.GoodsSPUVO;
import com.it.estore.service.GoodsSPUService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSPUServiceImpl implements GoodsSPUService {

    @Resource
    private GoodsSPUMapper goodsSPUMapper;

    @Override
    public void add(GoodsSPUVO goodsSPUVO) {
        goodsSPUMapper.insertSelective(goodsSPUVO);
    }

    @Override
    public void update(GoodsSPUVO goodsSPUVO) {
        goodsSPUMapper.updateByPrimaryKeySelective(goodsSPUVO);
    }

    @Override
    public void delete(Long id) {
        goodsSPUMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsSPUVO> findAll() {
        return goodsSPUMapper.selectAll();
    }

    @Override
    public GoodsSPUVO findOneById(Long id) {
        return goodsSPUMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GoodsSPUVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<GoodsSPUVO> goodsSPUVOS = goodsSPUMapper.selectAll();
        return new PageInfo<>(goodsSPUVOS);
    }

    @Override
    public PageInfo<GoodsSPUVO> findPage(GoodsSPUVO goodsSPUVO, Integer page, Integer size) {
        return null;
    }
}
