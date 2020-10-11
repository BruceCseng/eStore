package com.it.estore.controller;


import com.it.estore.goods.vo.GoodsSpecVO;
import com.it.estore.service.GoodsSpecService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsSpec")
@CrossOrigin
public class GoodsSpecController {

    @Resource
    GoodsSpecService goodsSpecService;

    /**
     * 根据分类id查询模板信息
     */
    @GetMapping("/category/{id}")
    public Result<List<GoodsSpecVO>> findByCategoryId(@PathVariable(value = "id")Long id){
        List<GoodsSpecVO> goodsSpecVOS = goodsSpecService.findByCategory(id);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",goodsSpecVOS);
    }
}
