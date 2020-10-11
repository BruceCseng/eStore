package com.it.estore.controller;


import com.it.estore.goods.vo.GoodsVO;
import com.it.estore.service.GoodsSPUService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodsSpu")
@CrossOrigin
public class GoodsSPUController {

    @Resource
    private GoodsSPUService goodsSPUService;


    @PutMapping("/batch/put")
    public Result batchPut(@RequestBody Long[] ids){
        goodsSPUService.batchPut(ids);
        return new Result(true,StatueCode.SUCCESS_CODE,"批量上架成功");
    }

    @PutMapping("/put/{id}")
    public Result put(@PathVariable(value = "id")Long spuId){
        goodsSPUService.put(spuId);
        return new Result(true,StatueCode.SUCCESS_CODE,"上架成功");
    }

    @PutMapping("/pull/{id}")
    public Result pull(@PathVariable(value = "id")Long spuId){
        goodsSPUService.pull(spuId);
        return new Result(true,StatueCode.SUCCESS_CODE,"下架成功");
    }

    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable(value = "id")Long spuId){
        goodsSPUService.audit(spuId);
        return new Result(true,StatueCode.SUCCESS_CODE,"审核成功");
    }

    @GetMapping("/goods/{id}")
    public Result<GoodsVO> findGoodsById(@PathVariable(value = "id")Long id){
        GoodsVO goods = goodsSPUService.findGoodsById(id);
        return new Result<>(true,StatueCode.SUCCESS_CODE,"success",goods);
    }

    @PostMapping("/save")
    public Result saveGoods(@RequestBody GoodsVO goodsVO){
        goodsSPUService.saveGoods(goodsVO);
        return new Result(true, StatueCode.SUCCESS_CODE,"保存商品成功");
    }
}
