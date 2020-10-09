package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.GoodsParaVO;

import java.util.List;

public interface GoodsParaService {

    void add(GoodsParaVO paraVO);

    void delete(Long id);

    void update(GoodsParaVO paraVO);

    GoodsParaVO findById(Long id);

    List<GoodsParaVO> findAll();

    List<GoodsParaVO> findList(GoodsParaVO paraVO);

    PageInfo<GoodsParaVO> findPage(Integer page, Integer size);

    PageInfo<GoodsParaVO> findPage(GoodsParaVO paraVO, Integer page, Integer size);

}
