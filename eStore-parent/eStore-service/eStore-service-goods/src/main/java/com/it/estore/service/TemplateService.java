package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.AlbumVO;
import com.it.estore.goods.vo.TemplateVO;

import java.util.List;

public interface TemplateService {

    void add(TemplateVO templateVO);

    void delete(Long id);

    void update(TemplateVO templateVO);

    TemplateVO findById(Long id);

    List<TemplateVO> findAll();

    List<TemplateVO> findList(TemplateVO templateVO);

    PageInfo<TemplateVO> findPage(Integer page, Integer size);

    PageInfo<TemplateVO> findPage(TemplateVO templateVO, Integer page, Integer size);

}
