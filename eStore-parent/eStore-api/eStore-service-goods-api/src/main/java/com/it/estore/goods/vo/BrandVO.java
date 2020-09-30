package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_brand")
public class BrandVO {

    @ApiModelProperty(value = "品牌编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long brandId;

    @ApiModelProperty(value = "品牌名称",required = false)
    @Column(name = "name")
    private String brandName;

    @ApiModelProperty(value = "品牌图标",required = false)
    @Column(name = "image")
    private String brandImage;

    @ApiModelProperty(value = "品牌首字母",required = false)
    @Column(name = "letter")
    private String brandLetter;

    @ApiModelProperty(value = "排序",required = false)
    @Column(name = "sort")
    private Integer sortNum;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandLetter() {
        return brandLetter;
    }

    public void setBrandLetter(String brandLetter) {
        this.brandLetter = brandLetter;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
