package com.it.estore.user.feign;

import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="user")
@RequestMapping("/user")
public interface UserFeign {

    @GetMapping("/load/{id}")
    Result<UserVO> findByUsername(@PathVariable(name="id") String id);

    @PostMapping("/add")
    Result add(@RequestBody UserVO userVO);
}
