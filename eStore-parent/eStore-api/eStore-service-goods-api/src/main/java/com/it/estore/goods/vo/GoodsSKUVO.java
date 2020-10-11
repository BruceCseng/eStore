package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "Bruce", value = "Bruce")
@Table(name = "tb_sku")
public class GoodsSKUVO {

    @ApiModelProperty(value = "skuid", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//` int(10) NOT NULL,

    @ApiModelProperty(value = "商品条码",required = false)
    @Column(name = "sn")
    private String sn;

    @ApiModelProperty(value = "SKU名称",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "价格(分)",required = false)
    @Column(name = "price")
    private Integer price;

    @ApiModelProperty(value = "库存数量",required = false)
    @Column(name = "num")
    private Integer num;

    @ApiModelProperty(value = "库存预警数量",required = false)
    @Column(name = "alert_num")
    private Integer alertNum;

    @ApiModelProperty(value = "商品图片",required = false)
    @Column(name = "image")
    private String image;

    @ApiModelProperty(value = "商品图片列表",required = false)
    @Column(name = "images")
    private String images;

    @ApiModelProperty(value = "重量(克)",required = false)
    @Column(name = "weight")
    private Integer weight;

    @ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "SPUID",required = false)
    @Column(name = "spu_id")
    private Long spuId;

    @ApiModelProperty(value = "品类id",required = false)
    @Column(name = "category_id")
    private Long categoryId;

    @ApiModelProperty(value = "品类名称",required = false)
    @Column(name = "category_name")
    private String categoryName;

    @ApiModelProperty(value = "品牌名称",required = false)
    @Column(name = "brand_name")
    private String brandName;

    @ApiModelProperty(value = "规格",required = false)
    @Column(name = "spec")
    private String spec;

    @ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
    private Integer saleNum;

    @ApiModelProperty(value = "评论数",required = false)
    @Column(name = "comment_num")
    private Integer commentNum;

    @ApiModelProperty(value = "商品状态1-正常，2-下架，3-下架",required = false)
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAlertNum() {
        return alertNum;
    }

    public void setAlertNum(Integer alertNum) {
        this.alertNum = alertNum;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
