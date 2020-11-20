package com.it.estore.service;

import com.github.pagehelper.PageInfo;
import com.it.estore.profile.vo.BlogVO;
import com.it.estore.profile.vo.ContentVO;
import com.it.estore.profile.vo.MainMenuVO;
import com.it.estore.profile.vo.MessageVO;

import java.util.List;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午9:32
 * @Description: com.it.estore.service
 * @Version: 1.0
 */
public interface ProfileService {

    ContentVO findContent(ContentVO contentVO);

    List<ContentVO> findContentList(ContentVO contentVO);

    List<MainMenuVO> findAllMainMenu();

    PageInfo<BlogVO> findPage(Integer page, Integer size);

    void addMessage(MessageVO messageVO);
}
