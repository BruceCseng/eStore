package com.it.estore.controller;

import com.it.estore.goods.vo.CategoryVO;
import com.it.estore.service.CategoryService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list/{pid}")
    public Result<List<CategoryVO>> findByParentId(@PathVariable(value = "pid")Long pid){
        List<CategoryVO> categoryVOS = categoryService.findByParentId(pid);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"查询成功",categoryVOS);
    }
}
