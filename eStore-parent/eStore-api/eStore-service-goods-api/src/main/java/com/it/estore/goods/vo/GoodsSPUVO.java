package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce", value = "Bruce")
@Table(name = "tb_spu")
public class GoodsSPUVO {

    @ApiModelProperty(value = "spuid",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "货号",required = false)
    @Column(name = "sn")
    private String sn;

    @ApiModelProperty(value = "spu名",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "副标题",required = false)
    @Column(name = "caption")
    private String caption;

    @ApiModelProperty(value = "品牌id",required = false)
    @Column(name = "brand_id")
    private Integer brandId;

    @ApiModelProperty(value = "一级分类",required = false)
    @Column(name = "category1_id")
    private Integer category1Id;

    @ApiModelProperty(value = "二级分类",required = false)
    @Column(name = "category2_id")
    private Integer category2Id;

    @ApiModelProperty(value = "三级分类",required = false)
    @Column(name = "category3_id")
    private Integer category3Id;

    @ApiModelProperty(value = "运费模板id",required = false)
    @Column(name = "freight_id")
    private Integer freightId;

    @ApiModelProperty(value = "图片",required = false)
    @Column(name = "image")
    private String image;

    @ApiModelProperty(value = "图片列表",required = false)
    @Column(name = "images")
    private String images;

    @ApiModelProperty(value = "售后服务",required = false)
    @Column(name = "sale_service")
    private String saleService;

    @ApiModelProperty(value = "介绍",required = false)
    @Column(name = "introduction")
    private String introduction;

    @ApiModelProperty(value = "规格列表",required = false)
    @Column(name = "spec_items")
    private String specItems;

    @ApiModelProperty(value = "参数列表",required = false)
    @Column(name = "para_items")
    private String paraItems;

    @ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
    private Integer saleNum;

    @ApiModelProperty(value = "评论数",required = false)
    @Column(name = "comment_num")
    private Integer commentNum;

    @ApiModelProperty(value = "是否上架",required = false)
    @Column(name = "is_marketable")
    private String isMarketable;

    @ApiModelProperty(value = "是否启用规格",required = false)
    @Column(name = "is_enable_spec")
    private String isEnableSpec;

    @ApiModelProperty(value = "是否删除",required = false)
    @Column(name = "is_delete")
    private String isDelete;

    @ApiModelProperty(value = "审核状态",required = false)
    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    public Integer getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    public Integer getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Integer category3Id) {
        this.category3Id = category3Id;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpecItems() {
        return specItems;
    }

    public void setSpecItems(String specItems) {
        this.specItems = specItems;
    }

    public String getParaItems() {
        return paraItems;
    }

    public void setParaItems(String paraItems) {
        this.paraItems = paraItems;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
