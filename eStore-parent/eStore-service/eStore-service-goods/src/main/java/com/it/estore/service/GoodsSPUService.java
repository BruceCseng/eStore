package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.GoodsSPUVO;
import com.it.estore.goods.vo.GoodsSpecVO;
import com.it.estore.goods.vo.GoodsVO;

import java.util.List;

public interface GoodsSPUService {

    /**
     * 批量上架
     * @param ids
     */
    void batchPut(Long[] ids);

    /**
     * 商品上架
     * @param spuId
     */
    void put(Long spuId);

    /**
     * 商品下架
     * @param spuId
     */
    void pull(Long spuId);

    /**
     * 商品审核
     * @param spuId
     */
    void audit(Long spuId);

    /**
     * 根据id查询goods数据
     * @param id
     * @return
     */
    GoodsVO findGoodsById(Long id);

    /**
     * 添加商品信息
     * @param goodsVO
     */
    void saveGoods(GoodsVO goodsVO);

    void add(GoodsSPUVO goodsSPUVO);

    void update(GoodsSPUVO goodsSPUVO);

    void delete(Long id);

    List<GoodsSPUVO> findAll();

    GoodsSPUVO findOneById(Long id);

    PageInfo<GoodsSPUVO> findPage(Integer page, Integer size);

    PageInfo<GoodsSPUVO> findPage(GoodsSPUVO goodsSPUVO, Integer page, Integer size);

}
