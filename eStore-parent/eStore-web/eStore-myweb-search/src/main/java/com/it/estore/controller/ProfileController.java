package com.it.estore.controller;

import com.github.pagehelper.PageInfo;
import com.it.estore.profile.feign.ProfileFeign;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.utils.Result;
import com.it.estore.enums.TypeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/15 下午10:32
 * @Description: com.it.estore.controller
 * @Version: 1.0
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileFeign profileFeign;

    @GetMapping("/index")
    public String index(Model model) {
        ContentVO contentVO = new ContentVO();
        // 查询博客
        Result<PageInfo<BlogVO>> blogList = profileFeign.findBlogList(1, 3);
        Result<List<MainMenuVO>> allMainMenu = profileFeign.findAllMainMenu();
        Integer no1ParentId = 0;
        Integer no2ParentId = 0;
        Integer no3ParentId = 0;
        Integer no4ParentId = 0;
        Integer no5ParentId = 0;
        for (MainMenuVO mainMenu : allMainMenu.getData()) {
            switch (mainMenu.getSortNo()) {
                case 1:
                    no1ParentId = mainMenu.getId();
                    break;
                case 2:
                    no2ParentId = mainMenu.getId();
                    break;
                case 3:
                    no3ParentId = mainMenu.getId();
                    break;
                case 4:
                    no4ParentId = mainMenu.getId();
                    break;
                case 5:
                    no5ParentId = mainMenu.getId();
                    break;
            }
        }
        // 查询第一的相关信息
        contentVO.setType(TypeCode.H1_LEVEL.getType());
        contentVO.setParentId(no1ParentId);
        Result<ContentVO> h1Level = profileFeign.findContent(contentVO);
        // 查询第二的相关信息
        contentVO.setParentId(no2ParentId);
        Result<ContentVO> h2Level = profileFeign.findContent(contentVO);
        // 查询第三的相关信息
        contentVO.setParentId(no3ParentId);
        Result<ContentVO> h3Level = profileFeign.findContent(contentVO);
        // 查询第四的相关信息
        contentVO.setParentId(no4ParentId);
        Result<ContentVO> h4Level = profileFeign.findContent(contentVO);
        // 查询第五的相关信息
        contentVO.setParentId(no5ParentId);
        Result<ContentVO> h5Level = profileFeign.findContent(contentVO);
        model.addAttribute("selfDesc", h1Level);
        model.addAttribute("careerDesc", h2Level);
        model.addAttribute("portfolioDesc", h3Level);
        model.addAttribute("blogDesc", h4Level);
        model.addAttribute("contactDesc", h5Level);
        model.addAttribute("blogList", blogList);
        //model.addAttribute("projectList", allProject);

        return "index-video-background";
    }
}
