package com.it.estore.controller;

import com.it.estore.profile.feign.ProfileFeign;
import com.it.estore.profile.vo.AboutMeVO;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.CareerVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.ProfileVO;
import com.it.estore.profile.vo.ProjectVO;
import com.it.estore.utils.Result;
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
        // 查询博客
        Result<List<BlogVO>> allBlog = profileFeign.findAllBlog();
        Result<List<CareerVO>> allCareer = profileFeign.findAllCareer();
        Result<List<MainMenuVO>> allMainMenu = profileFeign.findAllMainMenu();
        Result<List<ProfileVO>> allProfile = profileFeign.findAllProfile();
        Result<List<ProjectVO>> allProject = profileFeign.findAllProject();
        Result<AboutMeVO> selfDesc = profileFeign.findSelfDesc();
        String type = "1";
        Result<List<AboutMeVO>> AboutMeList = profileFeign.findAboutMeByType(type);
        model.addAttribute("blogList", allBlog);
        model.addAttribute("careerList", allCareer);
        model.addAttribute("AboutMeList", AboutMeList);
        model.addAttribute("mainMenuList", allMainMenu);
        model.addAttribute("profileList", allProfile);
        model.addAttribute("projectList", allProject);
        model.addAttribute("selfDesc", selfDesc);
        return "index-video-background";
    }
}
