package com.it.estore.controller;

import com.it.estore.goods.vo.GoodsParaVO;
import com.it.estore.service.GoodsParaService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsPara")
@CrossOrigin
public class GoodsParaController {

    @Resource
    private GoodsParaService goodsParaService;

    @GetMapping("/findGoodsPara/{id}")
    public Result<List<GoodsParaVO>> getByCategoryId(@PathVariable(value = "id")Long id){
        List<GoodsParaVO> goodsParaVOS = goodsParaService.findByCategory(id);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",goodsParaVOS);
    }
}
