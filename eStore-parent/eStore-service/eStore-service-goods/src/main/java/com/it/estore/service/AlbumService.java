package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.AlbumVO;

import java.util.List;

public interface AlbumService {

    void add(AlbumVO albumVO);

    void delete(Long id);

    void update(AlbumVO albumVO);

    AlbumVO findById(Long id);

    List<AlbumVO> findAll();

    List<AlbumVO> findList(AlbumVO albumVO);

    PageInfo<AlbumVO> findPage(Integer page, Integer size);

    PageInfo<AlbumVO> findPage(AlbumVO albumVO, Integer page, Integer size);
}
