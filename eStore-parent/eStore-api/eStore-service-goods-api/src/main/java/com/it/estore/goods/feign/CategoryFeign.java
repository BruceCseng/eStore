package com.it.estore.goods.feign;

import com.it.estore.goods.vo.CategoryVO;
import com.it.estore.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="goods")
@RequestMapping("/category")
public interface CategoryFeign {

    @GetMapping("/{id}")
    public Result<CategoryVO> findById(@PathVariable(name = "id") Integer id);
}
