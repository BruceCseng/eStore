package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.BrandVO;

import java.util.List;

public interface BrandService {

    List<BrandVO> findAll();

    BrandVO findById(Long id);

    void add(BrandVO brand);

    void update(BrandVO brand);

    void delete(Long id);

    List<BrandVO> findList(BrandVO brand);

    PageInfo<BrandVO> findPage(Integer page, Integer size);

    PageInfo<BrandVO> findPage(BrandVO brand, Integer page, Integer size);
}
