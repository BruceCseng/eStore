package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.BrandMapper;
import com.it.estore.goods.vo.BrandVO;
import com.it.estore.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<BrandVO> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public BrandVO findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(BrandVO brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(BrandVO brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Long id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BrandVO> findList(BrandVO brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<BrandVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<BrandVO> brands = brandMapper.selectAll();
        return new PageInfo<>(brands);
    }

    @Override
    public PageInfo<BrandVO> findPage(BrandVO brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(brand);
        List<BrandVO> brands = brandMapper.selectByExample(example);
        return new PageInfo<>(brands);
    }

    private Example createExample(BrandVO brand){
        Example example = new Example(BrandVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(!StringUtils.isEmpty(brand.getBrandName())){
                criteria.andLike("brandName","%"+brand.getBrandName()+"%");
            }
            if(!StringUtils.isEmpty(brand.getBrandLetter())){
                criteria.andEqualTo("brandLetter",brand.getBrandLetter());
            }
            return example;
        }
        return null;
    }
}
