package com.it.estore.controller;

import com.it.estore.profile.vo.AboutMeVO;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.CareerVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.ProfileVO;
import com.it.estore.profile.vo.ProjectVO;
import com.it.estore.service.ProfileService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/findAllAboutMe")
    public Result<List<AboutMeVO>> findAllAboutMe() {
        List<AboutMeVO> aboutMe = profileService.findAboutMe();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", aboutMe);
    }

    @GetMapping("/findAllBlog")
    public Result<List<ProjectVO>> findAllBlog() {
        List<BlogVO> allBlog = profileService.findAllBlog();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allBlog);
    }

    @GetMapping("/findAllCareer")
    public Result<List<CareerVO>> findAllCareer() {
        List<CareerVO> allCareer = profileService.findAllCareer();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allCareer);
    }

    @GetMapping("/findAllMainMenu")
    public Result<List<MainMenuVO>> findAllMainMenu() {
        List<MainMenuVO> allMainMenu = profileService.findAllMainMenu();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allMainMenu);
    }

    @GetMapping("/findAllProfile")
    public Result<List<ProfileVO>> findAllProfile() {
        List<ProfileVO> allProfile = profileService.findAllProfile();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allProfile);
    }

    @GetMapping("/findAllProject")
    public Result<List<ProjectVO>> findAllProject() {
        List<ProjectVO> allProject = profileService.findAllProject();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", allProject);
    }

    @GetMapping("/findSelfDesc")
    public Result<AboutMeVO> findSelfDesc() {
        AboutMeVO selfDesc = profileService.findSelfDesc();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", selfDesc);
    }

    @GetMapping("/findAboutMeByType/{type}")
    public Result<List<AboutMeVO>> findAboutMeByType(@PathVariable(name = "type") String type) {
        List<AboutMeVO> aboutMeByType = profileService.findAboutMeByType(type);
        return new Result<>(true, StatueCode.SUCCESS_CODE, "success", aboutMeByType);
    }
}
