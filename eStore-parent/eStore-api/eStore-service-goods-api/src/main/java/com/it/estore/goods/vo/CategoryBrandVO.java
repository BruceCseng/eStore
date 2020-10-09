package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_category_brand")
public class CategoryBrandVO {

    @ApiModelProperty(value = "编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "品类编号",required = false)
    @Column(name = "category_id")
    private Long categoryId;

    @ApiModelProperty(value = "品牌编号",required = false)
    @Column(name = "brand_id")
    private Long brandId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
