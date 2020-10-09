package com.it.estore.dao;

import com.it.estore.goods.vo.CategoryVO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<CategoryVO> {

}
