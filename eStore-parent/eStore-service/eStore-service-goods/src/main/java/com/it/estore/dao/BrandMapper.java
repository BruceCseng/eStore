package com.it.estore.dao;

import com.it.estore.goods.vo.BrandVO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<BrandVO> {

    @Select("SELECT * FROM tb_brand brand,tb_category_brand tcb WHERE brand.id = tcb.brand_id AND tcb.category_id = #{categoryId}")
    List<BrandVO> findCategoryId(Long categoryId);
}
