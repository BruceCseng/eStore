package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.GoodsSKUVO;
import com.it.estore.goods.vo.GoodsSpecVO;

import java.util.List;

public interface GoodsSpecService {

    void add(GoodsSpecVO goodsSpecVO);

    void update(GoodsSpecVO goodsSpecVO);

    void delete(Long id);

    List<GoodsSpecVO> findAll();

    GoodsSpecVO findOneById(Long id);

    PageInfo<GoodsSpecVO> findPage(Integer page, Integer size);

    PageInfo<GoodsSpecVO> findPage(GoodsSpecVO goodsSpecVO, Integer page, Integer size);

}
