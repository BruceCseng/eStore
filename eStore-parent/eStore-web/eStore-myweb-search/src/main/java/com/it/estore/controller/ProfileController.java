package com.it.estore.controller;

import com.github.pagehelper.PageInfo;
import com.it.estore.enums.TypeCode;
import com.it.estore.profile.feign.ProfileFeign;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.MessageVO;
import com.it.estore.utils.NetUtils;
import com.it.estore.utils.RedisUtils;
import com.it.estore.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private ProfileFeign profileFeign;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/index")
    public String index(Model model) {
        ContentVO contentVO = new ContentVO();
        // 查询博客
        Result<PageInfo<BlogVO>> blogList = profileFeign.findBlogList(1, 3);
        blogList.getData().getList().forEach(blogVO -> {
            String createDateStr = blogVO.getCreateDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date createDate = sdf.parse(createDateStr);
                int day = differentDaysByMillisecond(createDate, new Date());
                if (day >= 1) {
                    blogVO.setCreateDate(String.valueOf(day));
                    blogVO.setIsHours(false);
                } else {
                    int i = differentSecondByMillisecond(createDate, new Date());
                    blogVO.setCreateDate(String.valueOf(i));
                    blogVO.setIsHours(true);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });
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
        contentVO.setType(TypeCode.H1_LEVEL.getCode());
        contentVO.setParentId(no1ParentId);
        Result<ContentVO> h1Level = profileFeign.findContent(contentVO);
        contentVO.setType(TypeCode.H2_LEVEL.getCode());
        Result<List<ContentVO>> skillList = profileFeign.findContentList(contentVO);
        // 查询第二的相关信息
        contentVO.setParentId(no2ParentId);
        contentVO.setType(TypeCode.H1_LEVEL.getCode());
        Result<ContentVO> h2Level = profileFeign.findContent(contentVO);
        contentVO.setType(TypeCode.H2_LEVEL.getCode());
        Result<List<ContentVO>> careerList = profileFeign.findContentList(contentVO);
        // 查询hireMe相关
        contentVO.setType(TypeCode.H0_LEVEL.getCode());
        Result<ContentVO> hireMe = profileFeign.findContent(contentVO);

        contentVO.setType(TypeCode.H3_LEVEL.getCode());
        Result<ContentVO> adviceDesc = profileFeign.findContent(contentVO);

        contentVO.setType(TypeCode.H4_LEVEL.getCode());
        Result<List<ContentVO>> adviceList = profileFeign.findContentList(contentVO);
        // 查询第三的相关信息
        contentVO.setParentId(no3ParentId);
        contentVO.setType(TypeCode.H1_LEVEL.getCode());
        Result<ContentVO> h3Level = profileFeign.findContent(contentVO);
        // 查询第四的相关信息
        contentVO.setParentId(no4ParentId);
        contentVO.setType(TypeCode.H1_LEVEL.getCode());
        Result<ContentVO> h4Level = profileFeign.findContent(contentVO);
        // 查询第五的相关信息
        contentVO.setParentId(no5ParentId);
        contentVO.setType(TypeCode.H1_LEVEL.getCode());
        Result<ContentVO> h5Level = profileFeign.findContent(contentVO);
        // 查询地址相关
        contentVO.setParentId(null);
        contentVO.setType(TypeCode.H4_LEVEL.getCode());
        Result<List<ContentVO>> contactList = profileFeign.findContentList(contentVO);
        model.addAttribute("selfDesc", h1Level);
        model.addAttribute("AboutMeList", skillList);
        model.addAttribute("mainMenuList", allMainMenu);
        model.addAttribute("careerDesc", h2Level);
        model.addAttribute("careerList", careerList);
        model.addAttribute("hireMe", hireMe);
        model.addAttribute("adviceDesc", adviceDesc);
        model.addAttribute("adviceList", adviceList);
        model.addAttribute("portfolioDesc", h3Level);
        model.addAttribute("blogDesc", h4Level);
        model.addAttribute("contactDesc", h5Level);
        model.addAttribute("blogList", blogList);
        model.addAttribute("contactList", contactList);

        return "index-video-background";
    }

    @PostMapping("/leaveMsg")
    public void leaveMessage(HttpServletRequest request, HttpServletResponse response) {
        // 记录提交ip地址
        String ip = NetUtils.getIp2(request);
        PrintWriter writer;
        try {
            writer = response.getWriter();
            String s = redisUtils.get(ip);
            if (!StringUtils.isEmpty(s)) {
                writer.write("not");
                return;
            }
            redisUtils.setEx(ip, ip, 300L, TimeUnit.SECONDS);
            MessageVO messageVO = this.getMessageVO(request);
            profileFeign.addMessage(messageVO);
            writer.write("sent");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private MessageVO getMessageVO(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
        MessageVO messageVO = new MessageVO();
        messageVO.setName(name);
        messageVO.setEmail(email);
        messageVO.setPhone(phone);
        messageVO.setMessage(message);
        return messageVO;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    private static int differentDaysByMillisecond(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    private static int differentSecondByMillisecond(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600));
    }
}
