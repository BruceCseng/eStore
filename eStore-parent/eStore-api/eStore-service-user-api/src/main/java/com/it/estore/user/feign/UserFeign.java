package com.it.estore.user.feign;

import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user")
@RequestMapping("/user")
public interface UserFeign {

    @GetMapping("/load/{id}")
    Result<UserVO> findByUsername(@PathVariable(name="id") String id);

    @PostMapping("/add")
    Result add(@RequestBody UserVO userVO);
}
