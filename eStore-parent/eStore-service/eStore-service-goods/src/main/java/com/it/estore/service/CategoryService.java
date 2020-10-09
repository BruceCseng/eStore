package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.BrandVO;
import com.it.estore.goods.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    /**
     * 根据分类的父节点查询所有子节点集合
     * @param pid 父节点id=>1级分类等
     * @return
     */
    List<CategoryVO> findByParentId(Long pid);

    void add(CategoryVO categoryVO);

    void update(CategoryVO categoryVO);

    void delete(Long id);

    List<CategoryVO> findAll();

    CategoryVO findOneById(Long id);

    PageInfo<CategoryVO> findPage(Integer page, Integer size);

    PageInfo<CategoryVO> findPage(CategoryVO categoryVO, Integer page, Integer size);
}
