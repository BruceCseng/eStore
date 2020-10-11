package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.CategoryMapper;
import com.it.estore.dao.GoodsParaMapper;
import com.it.estore.goods.vo.AlbumVO;
import com.it.estore.goods.vo.CategoryVO;
import com.it.estore.goods.vo.GoodsParaVO;
import com.it.estore.service.GoodsParaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsParaServiceImpl implements GoodsParaService {

    @Resource
    private GoodsParaMapper goodsParaMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<GoodsParaVO> findByCategory(Long categoryId) {
        CategoryVO categoryVO = categoryMapper.selectByPrimaryKey(categoryId);
        GoodsParaVO goodsParaVO = new GoodsParaVO();
        goodsParaVO.setTemplateId(categoryVO.getTemplateId());
        return goodsParaMapper.select(goodsParaVO);
    }

    @Override
    public void add(GoodsParaVO paraVO) {
        goodsParaMapper.insertSelective(paraVO);
    }

    @Override
    public void delete(Long id) {
        goodsParaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(GoodsParaVO paraVO) {
        goodsParaMapper.updateByPrimaryKeySelective(paraVO);
    }

    @Override
    public GoodsParaVO findById(Long id) {
        return goodsParaMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GoodsParaVO> findAll() {
        return goodsParaMapper.selectAll();
    }

    @Override
    public List<GoodsParaVO> findList(GoodsParaVO paraVO) {
        Example example = this.createExample(paraVO);
        return goodsParaMapper.selectByExample(example);
    }

    @Override
    public PageInfo<GoodsParaVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<GoodsParaVO> goodsParaVOS = goodsParaMapper.selectAll();
        return new PageInfo<>(goodsParaVOS);
    }

    @Override
    public PageInfo<GoodsParaVO> findPage(GoodsParaVO paraVO, Integer page, Integer size) {
        return null;
    }

    private Example createExample(GoodsParaVO paraVO){
        Example example = new Example(GoodsParaVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(paraVO!=null){
            if(!StringUtils.isEmpty(paraVO.getName())){
                criteria.andLike("name","%"+paraVO.getName()+"%");
            }
            if(!StringUtils.isEmpty(paraVO.getOptions())){
                criteria.andLike("options","%"+paraVO.getOptions()+"%");
            }
            if(!paraVO.getSort().equals(0)&&paraVO.getSort()!=0){
                criteria.andEqualTo("sort",paraVO.getSort());
            }
            if(!paraVO.getTemplateId().equals(0)&&paraVO.getTemplateId()!=0){
                criteria.andEqualTo("templateId",paraVO.getTemplateId());
            }
            return example;
        }
        return null;
    }
}
