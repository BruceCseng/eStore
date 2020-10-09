package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.CategoryBrandMapper;
import com.it.estore.goods.vo.CategoryBrandVO;
import com.it.estore.service.CategoryBrandService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public void add(CategoryBrandVO categoryBrandVO) {
        categoryBrandMapper.insertSelective(categoryBrandVO);
    }

    @Override
    public void update(CategoryBrandVO categoryBrandVO) {
        categoryBrandMapper.updateByPrimaryKeySelective(categoryBrandVO);
    }

    @Override
    public void delete(Long id) {
        categoryBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryBrandVO> findAll() {
        List<CategoryBrandVO> categoryBrandVOS = categoryBrandMapper.selectAll();
        return categoryBrandVOS;
    }

    @Override
    public CategoryBrandVO findOneById(Long id) {
        CategoryBrandVO categoryBrandVO = categoryBrandMapper.selectByPrimaryKey(id);
        return categoryBrandVO;
    }

    @Override
    public PageInfo<CategoryBrandVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<CategoryBrandVO> categoryBrandVOS = categoryBrandMapper.selectAll();
        return new PageInfo<>(categoryBrandVOS);
    }

    @Override
    public PageInfo<CategoryBrandVO> findPage(CategoryBrandVO categoryBrandVO, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = this.createExample(categoryBrandVO);
        List<CategoryBrandVO> categoryBrandVOS = categoryBrandMapper.selectByExample(example);
        return new PageInfo<>(categoryBrandVOS);
    }

    private Example createExample(CategoryBrandVO categoryBrandVO){
        Example example = new Example(CategoryBrandVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(categoryBrandVO!=null){
            if(categoryBrandVO.getBrandId()!=0&&!categoryBrandVO.getBrandId().equals(0)){
                criteria.andEqualTo("brandId",categoryBrandVO.getBrandId());
            }
            if(categoryBrandVO.getCategoryId()!=0&&!categoryBrandVO.getCategoryId().equals(0)){
                criteria.andEqualTo("categoryId",categoryBrandVO.getCategoryId());
            }
            return example;
        }
        return null;
    }
}
