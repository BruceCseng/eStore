package com.it.estore.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.BrandMapper;
import com.it.estore.dao.CategoryMapper;
import com.it.estore.dao.GoodsSKUMapper;
import com.it.estore.dao.GoodsSPUMapper;
import com.it.estore.goods.vo.*;
import com.it.estore.service.GoodsSPUService;
import com.it.estore.utils.IdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSPUServiceImpl implements GoodsSPUService {

    @Resource
    private GoodsSPUMapper goodsSPUMapper;

    @Resource
    private GoodsSKUMapper goodsSKUMapper;

    @Resource
    private IdWorker idWorker;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private BrandMapper brandMapper;

    @Override
    public void batchPut(Long[] ids) {
        // update tb_sku isMarketable=1 where id in (ids) and isdelete = 0 and status =1
        Example example = new Example(GoodsSPUVO.class);
        Example.Criteria criteria = example.createCriteria();
        // id in (ids)
        criteria.andIn("id", Arrays.asList(ids));
        // 未删除
        criteria.andEqualTo("isDelete","0");
        // 已审核
        criteria.andEqualTo("status","1");

        GoodsSPUVO goodsSPUVO = new GoodsSPUVO();
        goodsSPUVO.setIsMarketable("1");  // 上架
        goodsSPUMapper.updateByExampleSelective(goodsSPUVO,example);
    }

    @Override
    public void put(Long spuId) {
        GoodsSPUVO goodsSPUVO = goodsSPUMapper.selectByPrimaryKey(spuId);
        if("1".equals(goodsSPUVO.getIsDelete())){
            throw new RuntimeException("该商品已经被删除！");
        }
        if(!"1".equals(goodsSPUVO.getIsDelete())){
            throw new RuntimeException("该商品未通过审核！");
        }
        // 修改上架状态
        goodsSPUVO.setIsMarketable("1");//上架
        goodsSPUMapper.updateByPrimaryKeySelective(goodsSPUVO);
    }

    @Override
    public void pull(Long spuId) {
        GoodsSPUVO goodsSPUVO = goodsSPUMapper.selectByPrimaryKey(spuId);
        if("1".equals(goodsSPUVO.getIsDelete())){
            throw new RuntimeException("该商品已经被删除！");
        }
        // 修改下架状态
        goodsSPUVO.setIsMarketable("0");//下架
        goodsSPUMapper.updateByPrimaryKeySelective(goodsSPUVO);
    }

    @Override
    public void audit(Long spuId) {
        GoodsSPUVO goodsSPUVO = goodsSPUMapper.selectByPrimaryKey(spuId);
        if("1".equals(goodsSPUVO.getIsDelete())){
            throw new RuntimeException("该商品已经被删除！");
        }
        // 实现上架和审核
        goodsSPUVO.setStatus("1");//审核通过
        goodsSPUVO.setIsMarketable("1");//上架
        goodsSPUMapper.updateByPrimaryKeySelective(goodsSPUVO);
    }

    @Override
    public GoodsVO findGoodsById(Long id) {
        // 查询spu
        GoodsSPUVO spuvo = goodsSPUMapper.selectByPrimaryKey(id);
        // 查询List<Sku>-> select * from th_sku where spu_id = ?
        GoodsSKUVO sku = new GoodsSKUVO();
        sku.setSpuId(id);
        List<GoodsSKUVO> skuvoList = goodsSKUMapper.select(sku);
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setSpu(spuvo);
        goodsVO.setSkuList(skuvoList);
        return goodsVO;
    }

    @Override
    public void saveGoods(GoodsVO goodsVO) {
        GoodsSPUVO spu = goodsVO.getSpu();
        if(spu.getId()==null){
            // 为空，则增加
            spu.setId(idWorker.nextId());
            goodsSPUMapper.insertSelective(spu);
        }else {
            // 否则修改
            goodsSPUMapper.updateByPrimaryKeySelective(spu);

            // 删除之前的List<Sku>
            GoodsSKUVO skuvo = new GoodsSKUVO();
            skuvo.setSpuId(spu.getId());
            goodsSKUMapper.delete(skuvo);
        }

        // 查询3级分类
        CategoryVO categoryVO = categoryMapper.selectByPrimaryKey(spu.getCategory3Id());
        // 查询品牌
        BrandVO brandVO = brandMapper.selectByPrimaryKey(spu.getBrandId());
        Date date = new Date();
        //sku 增加
        List<GoodsSKUVO> skuList = goodsVO.getSkuList();
        for (GoodsSKUVO sku : skuList) {
            sku.setId(idWorker.nextId());
            // 获取spec的值  {"电视机音响效果":"立体声"}
            String name = spu.getName();
            //防止空指针
            if(StringUtils.isEmpty(sku.getSpec())){
                sku.setSpec("{}");
            }
            //将spec转成map
            Map<String,String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
            for(Map.Entry<String,String> entry: specMap.entrySet()){
                name += "  "+ entry.getValue();
            }
            sku.setName(name);
            sku.setCreateTime(date);
            sku.setUpdateTime(date);
            sku.setSpuId(spu.getId());
            sku.setCategoryId(spu.getCategory3Id());  // 分类Id->3级分类ID
            sku.setCategoryName(categoryVO.getName()); // 分类名字->3级分类名字
            sku.setBrandName(brandVO.getBrandName());  // 品牌名字
            goodsSKUMapper.insertSelective(sku);
        }
    }

    @Override
    public void add(GoodsSPUVO goodsSPUVO) {
        goodsSPUMapper.insertSelective(goodsSPUVO);
    }

    @Override
    public void update(GoodsSPUVO goodsSPUVO) {
        goodsSPUMapper.updateByPrimaryKeySelective(goodsSPUVO);
    }

    @Override
    public void delete(Long id) {
        goodsSPUMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GoodsSPUVO> findAll() {
        return goodsSPUMapper.selectAll();
    }

    @Override
    public GoodsSPUVO findOneById(Long id) {
        return goodsSPUMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<GoodsSPUVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<GoodsSPUVO> goodsSPUVOS = goodsSPUMapper.selectAll();
        return new PageInfo<>(goodsSPUVOS);
    }

    @Override
    public PageInfo<GoodsSPUVO> findPage(GoodsSPUVO goodsSPUVO, Integer page, Integer size) {
        return null;
    }
}
