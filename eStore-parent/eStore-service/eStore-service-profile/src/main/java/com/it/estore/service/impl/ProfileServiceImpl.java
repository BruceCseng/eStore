package com.it.estore.service.impl;

import com.it.estore.dao.AboutMeMapper;
import com.it.estore.dao.BlogMapper;
import com.it.estore.dao.CareerMapper;
import com.it.estore.dao.MainMenuMapper;
import com.it.estore.dao.ProfileMapper;
import com.it.estore.dao.ProjectMapper;
import com.it.estore.profile.vo.AboutMeVO;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.CareerVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.ProfileVO;
import com.it.estore.profile.vo.ProjectVO;
import com.it.estore.service.ProfileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午9:58
 * @Description: com.it.estore.service.impl
 * @Version: 1.0
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Resource
    private AboutMeMapper aboutMeMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private CareerMapper careerMapper;

    @Resource
    private MainMenuMapper mainMenuMapper;

    @Resource
    private ProfileMapper profileMapper;

    @Resource
    private ProjectMapper projectMapper;


    @Override
    public AboutMeVO findSelfDesc() {
        AboutMeVO param = new AboutMeVO();
        param.setType("0");
        return aboutMeMapper.selectOne(param);
    }

    @Override
    public List<AboutMeVO> findAboutMeByType(String type) {
        AboutMeVO aboutMeVO = new AboutMeVO();
        aboutMeVO.setType(type);
        Example example = createExample(aboutMeVO);
        return aboutMeMapper.selectByExample(example);
    }

    @Override
    public List<MainMenuVO> findAllMainMenu() {
        return mainMenuMapper.selectAll();
    }

    @Override
    public List<BlogVO> findAllBlog() {
        return blogMapper.selectAll();
    }

    @Override
    public List<CareerVO> findAllCareer() {
        return careerMapper.selectAll();
    }

    @Override
    public List<AboutMeVO> findAboutMe() {
        return aboutMeMapper.selectAll();
    }

    @Override
    public List<ProfileVO> findAllProfile() {
        return profileMapper.selectAll();
    }

    @Override
    public List<ProjectVO> findAllProject() {
        return projectMapper.selectAll();
    }

    private Example createExample(AboutMeVO aboutMeVO) {
        Example example = new Example(AboutMeVO.class);
        Example.Criteria criteria = example.createCriteria();
        if (aboutMeVO != null) {
            if (!StringUtils.isEmpty(aboutMeVO.getType())) {
                criteria.andEqualTo("type", aboutMeVO.getType());
            }
            return example;
        }
        return null;
    }
}
