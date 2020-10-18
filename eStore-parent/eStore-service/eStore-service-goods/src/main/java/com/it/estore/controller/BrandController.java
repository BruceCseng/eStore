package com.it.estore.controller;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.BrandVO;
import com.it.estore.utils.StatueCode;
import com.it.estore.utils.Result;
import com.it.estore.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
/**
 * 跨域，A域名访问B域名的数据，此时存在跨域
 */
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("/findCategory/{id}")
    public Result<List<BrandVO>> findBrandByCategory(@PathVariable("id")Long id){
        List<BrandVO> brandVOS = brandService.findByCategoryId(id);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",brandVOS);
    }

    @GetMapping("/findAllBrand")
    public Result<List<BrandVO>> findAllBrand(){
        List<BrandVO> allBrand = brandService.findAll();
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",allBrand);
    }

    @GetMapping("/findBrandById/{id}")
    public Result<BrandVO> findBrandById(@PathVariable("id")Long id){
        BrandVO brand = brandService.findById(id);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",brand);
    }

    @PostMapping("/addBrand")
    public Result addBrand(@RequestBody BrandVO brand){
        brandService.add(brand);
        return new Result(true, StatueCode.SUCCESS_CODE,"success");
    }

    @PutMapping("/updateBrand/{id}")
    public Result updateBrand(@PathVariable("id") Long id,@RequestBody BrandVO brand){
        brand.setBrandId(id);
        brandService.update(brand);
        return new Result(true, StatueCode.SUCCESS_CODE,"修改成功");
    }

    @DeleteMapping("/deleteBrand/{id}")
    public Result deleteBrand(@PathVariable("id") Long id){
        brandService.delete(id);
        return new Result(true, StatueCode.SUCCESS_CODE,"删除成功");
    }

    @PostMapping("/search")
    public Result<List<BrandVO>> search(@RequestBody BrandVO brand){
        List<BrandVO> list = brandService.findList(brand);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"条件搜索查询成功",list);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<BrandVO>> findPageInfo(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageInfo<BrandVO> list = brandService.findPage(page, size);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"分页查询成功",list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<BrandVO>> findPageInfo(@RequestBody BrandVO brand, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageInfo<BrandVO> list = brandService.findPage(brand,page, size);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"分页查询成功",list);
    }

}
