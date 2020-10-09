package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.GoodsSKUMapper;
import com.it.estore.goods.vo.GoodsSKUVO;
import com.it.estore.service.GoodsSKUService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSKUServiceImpl implements GoodsSKUService {

    @Resource
    private GoodsSKUMapper goodsSKUMapper;

    @Override
    public void add(GoodsSKUVO goodsSKUVO) {
        goodsSKUMapper.insertSelective(goodsSKUVO);
    }

    @Override
    public void update(GoodsSKUVO goodsSKUVO) {
        goodsSKUMapper.updateByPrimaryKeySelective(goodsSKUVO);
    }

    @Override
    public void delete(Long id) {
        goodsSKUMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsSKUVO> findAll() {
        List<GoodsSKUVO> goodsSKUVOS = goodsSKUMapper.selectAll();
        return goodsSKUVOS;
    }

    @Override
    public GoodsSKUVO findOneById(Long id) {
        GoodsSKUVO goodsSKUVO = goodsSKUMapper.selectByPrimaryKey(id);
        return goodsSKUVO;
    }

    @Override
    public PageInfo<GoodsSKUVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<GoodsSKUVO> goodsSKUVOS = goodsSKUMapper.selectAll();
        return new PageInfo<>(goodsSKUVOS);
    }

    @Override
    public PageInfo<GoodsSKUVO> findPage(GoodsSKUVO goodsSKUVO, Integer page, Integer size) {
        Example example = this.createExample(goodsSKUVO);
        List<GoodsSKUVO> goodsSKUVOS = goodsSKUMapper.selectByExample(example);
        return new PageInfo<>(goodsSKUVOS);
    }

    private Example createExample(GoodsSKUVO goodsSKUVO){
        Example example = new Example(GoodsSKUVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodsSKUVO!=null){
            if(!StringUtils.isEmpty(goodsSKUVO.getBrandName())){
                criteria.andLike("brandName","%"+goodsSKUVO.getBrandName()+"%");
            }
            if(!goodsSKUVO.getCategoryId().equals(0)&&goodsSKUVO.getCategoryId()!=0){
                criteria.andEqualTo("categoryId",goodsSKUVO.getCategoryId());
            }
            if(!StringUtils.isEmpty(goodsSKUVO.getName())){
                criteria.andLike("name","%"+goodsSKUVO.getName()+"%");
            }
            if(!goodsSKUVO.getSpuId().equals(0)&&goodsSKUVO.getSpuId()!=0){
                criteria.andEqualTo("supId",goodsSKUVO.getSpuId());
            }
            return example;
        }
        return null;
    }
}
