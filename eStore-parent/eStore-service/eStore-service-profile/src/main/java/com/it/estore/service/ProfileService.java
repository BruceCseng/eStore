package com.it.estore.service;

import com.it.estore.profile.vo.AboutMeVO;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.CareerVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.ProfileVO;
import com.it.estore.profile.vo.ProjectVO;

import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午9:32
 * @Description: com.it.estore.service
 * @Version: 1.0
 */
public interface ProfileService {

    AboutMeVO findSelfDesc();

    List<AboutMeVO> findAboutMeByType(String type);

    List<MainMenuVO> findAllMainMenu();

    List<BlogVO> findAllBlog();

    List<CareerVO> findAllCareer();

    List<AboutMeVO> findAboutMe();

    List<ProfileVO> findAllProfile();

    List<ProjectVO> findAllProject();
}
