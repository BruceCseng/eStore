package com.it.estore.goods.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息组合对象
 *
 */
public class GoodsVO implements Serializable {

    private GoodsSPUVO spu;

    private List<GoodsSKUVO> skuList;

    public GoodsSPUVO getSpu() {
        return spu;
    }

    public void setSpu(GoodsSPUVO spu) {
        this.spu = spu;
    }

    public List<GoodsSKUVO> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<GoodsSKUVO> skuList) {
        this.skuList = skuList;
    }
}
