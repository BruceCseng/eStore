package com.it.estore.profile.feign;

import com.it.estore.profile.vo.AboutMeVO;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.CareerVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.ProfileVO;
import com.it.estore.profile.vo.ProjectVO;
import com.it.estore.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/findAllBlog")
    Result<List<BlogVO>> findAllBlog();

    @GetMapping("/findAllAboutMe")
    Result<List<AboutMeVO>> findAllAboutMe();

    @GetMapping("/findAllCareer")
    Result<List<CareerVO>> findAllCareer();

    @GetMapping("/findAllMainMenu")
    Result<List<MainMenuVO>> findAllMainMenu();

    @GetMapping("/findAllProfile")
    Result<List<ProfileVO>> findAllProfile();

    @GetMapping("/findAllProject")
    Result<List<ProjectVO>> findAllProject();

    @GetMapping("/findSelfDesc")
    Result<AboutMeVO> findSelfDesc();

    @GetMapping("/findAboutMeByType/{type}")
    Result<List<AboutMeVO>> findAboutMeByType(@PathVariable(name = "type") String type);
}
