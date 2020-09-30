package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_category")
public class CategoryVO {

    @ApiModelProperty(value = "品类编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "品类名称",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "商品数量",required = false)
    @Column(name = "goods_num")
    private Integer goodsNum;

    @ApiModelProperty(value = "是否显示",required = false)
    @Column(name = "is_show")
    private String isShow;

    @ApiModelProperty(value = "是否为导航",required = false)
    @Column(name = "is_menu")
    private String isMenu;

    @ApiModelProperty(value = "排序",required = false)
    @Column(name = "sort")
    private Integer sort;

    @ApiModelProperty(value = "父类id",required = false)
    @Column(name = "parent_id")
    private Long parentId;

    @ApiModelProperty(value = "模板id",required = false)
    @Column(name = "template_id")
    private Long templateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
