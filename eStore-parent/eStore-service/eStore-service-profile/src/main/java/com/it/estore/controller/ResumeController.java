package com.it.estore.controller;

import com.github.pagehelper.PageInfo;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.MessageVO;
import com.it.estore.service.ProfileService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午10:07
 * @Description: com.it.estore.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/resume")
@CrossOrigin
public class ResumeController {

    @Resource
    private ProfileService profileService;

    @PostMapping("/findContent")
    public Result<ContentVO> findContent(@RequestBody ContentVO contentVO) {
        ContentVO content = profileService.findContent(contentVO);
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", content);
    }

    @PostMapping("/findContentList")
    public Result<List<ContentVO>> findContentList(@RequestBody ContentVO contentVO) {
        List<ContentVO> contentList = profileService.findContentList(contentVO);
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", contentList);
    }

    @GetMapping("/findBlogList/{page}/{size}")
    public Result<PageInfo<BlogVO>> findBlogList(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageInfo<BlogVO> blogVOPageInfo = profileService.findPage(page, size);
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", blogVOPageInfo);
    }

    @GetMapping("/findAllMainMenu")
    public Result<List<MainMenuVO>> findAllMainMenu() {
        List<MainMenuVO> allMainMenu = profileService.findAllMainMenu();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allMainMenu);
    }

    @PostMapping("/addMessage")
    public Result addMessage(@RequestBody MessageVO messageVO) {
        profileService.addMessage(messageVO);
        return new Result(true, StatueCode.SUCCESS_CODE, "success");
    }

}
