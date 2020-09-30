package com.it.estore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.estore.dao.AlbumMapper;
import com.it.estore.goods.vo.AlbumVO;
import com.it.estore.service.AlbumService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Resource
    private AlbumMapper albumMapper;


    @Override
    public void add(AlbumVO albumVO) {
        albumMapper.insertSelective(albumVO);
    }

    @Override
    public void delete(Long id) {
        albumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(AlbumVO albumVO) {
        albumMapper.updateByPrimaryKeySelective(albumVO);
    }

    @Override
    public AlbumVO findById(Long id) {
        AlbumVO albumVO = albumMapper.selectByPrimaryKey(id);
        return albumVO;
    }

    @Override
    public List<AlbumVO> findAll() {
        List<AlbumVO> albumVOS = albumMapper.selectAll();
        return albumVOS;
    }

    @Override
    public List<AlbumVO> findList(AlbumVO albumVO) {
        Example example = createExample(albumVO);
        return albumMapper.selectByExample(example);
    }

    @Override
    public PageInfo<AlbumVO> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<AlbumVO> albumVOS = albumMapper.selectAll();
        return new PageInfo<>(albumVOS);
    }

    @Override
    public PageInfo<AlbumVO> findPage(AlbumVO albumVO, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(albumVO);
        List<AlbumVO> albumVOS = albumMapper.selectByExample(example);
        return new PageInfo<>(albumVOS);
    }

    private Example createExample(AlbumVO albumVO){
        Example example = new Example(AlbumVO.class);
        Example.Criteria criteria = example.createCriteria();
        if(albumVO!=null){
            if(!StringUtils.isEmpty(albumVO.getTitle())){
                criteria.andLike("title","%"+albumVO.getTitle()+"%");
            }
            if(!StringUtils.isEmpty(albumVO.getImage())){
                criteria.andLike("image","%"+albumVO.getImage()+"%");
            }
            if(!StringUtils.isEmpty(albumVO.getImageItem())){
                criteria.andLike("imageItem","%"+albumVO.getImageItem()+"%");
            }
            return example;
        }
        return null;
    }
}
