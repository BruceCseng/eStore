package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.GoodsSPUVO;
import com.it.estore.goods.vo.GoodsSpecVO;

import java.util.List;

public interface GoodsSPUService {

    void add(GoodsSPUVO goodsSPUVO);

    void update(GoodsSPUVO goodsSPUVO);

    void delete(Long id);

    List<GoodsSPUVO> findAll();

    GoodsSPUVO findOneById(Long id);

    PageInfo<GoodsSPUVO> findPage(Integer page, Integer size);

    PageInfo<GoodsSPUVO> findPage(GoodsSPUVO goodsSPUVO, Integer page, Integer size);

}
