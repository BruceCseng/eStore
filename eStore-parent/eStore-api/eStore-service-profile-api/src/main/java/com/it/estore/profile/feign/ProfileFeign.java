package com.it.estore.profile.feign;


import com.github.pagehelper.PageInfo;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.MessageVO;
import com.it.estore.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午10:16
 * @Description: com.it.estore.profile.feign
 * @Version: 1.0
 */
@FeignClient(value = "profile")
@RequestMapping("/resume")
public interface ProfileFeign {

    @GetMapping("/findBlogList/{page}/{size}")
    Result<PageInfo<BlogVO>> findBlogList(@PathVariable("page") Integer page, @PathVariable("size") Integer size);

    @GetMapping("/findAllMainMenu")
    Result<List<MainMenuVO>> findAllMainMenu();

    @PostMapping("/findContent")
    Result<ContentVO> findContent(@RequestBody ContentVO contentVO);

    @PostMapping("/findContentList")
    Result<List<ContentVO>> findContentList(@RequestBody ContentVO contentVO);

    @PostMapping("/addMessage")
    Result addMessage(@RequestBody MessageVO messageVO);
}
