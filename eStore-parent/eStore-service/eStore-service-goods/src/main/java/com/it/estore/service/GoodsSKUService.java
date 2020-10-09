package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.CategoryBrandVO;
import com.it.estore.goods.vo.GoodsSKUVO;

import java.util.List;

public interface GoodsSKUService {

    void add(GoodsSKUVO goodsSKUVO);

    void update(GoodsSKUVO goodsSKUVO);

    void delete(Long id);

    List<GoodsSKUVO> findAll();

    GoodsSKUVO findOneById(Long id);

    PageInfo<GoodsSKUVO> findPage(Integer page, Integer size);

    PageInfo<GoodsSKUVO> findPage(GoodsSKUVO goodsSKUVO, Integer page, Integer size);

}
