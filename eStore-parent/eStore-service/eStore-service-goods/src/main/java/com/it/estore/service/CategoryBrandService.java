package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.CategoryBrandVO;

import java.util.List;

public interface CategoryBrandService {

    void add(CategoryBrandVO categoryBrandVO);

    void update(CategoryBrandVO categoryBrandVO);

    void delete(Long id);

    List<CategoryBrandVO> findAll();

    CategoryBrandVO findOneById(Long id);

    PageInfo<CategoryBrandVO> findPage(Integer page, Integer size);

    PageInfo<CategoryBrandVO> findPage(CategoryBrandVO categoryBrandVO, Integer page, Integer size);
}
