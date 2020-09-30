package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private Integer alert_num;

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
    private String create_time;

    @ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
    private String update_time;

    @ApiModelProperty(value = "SPUID",required = false)
    @Column(name = "spu_id")
    private Integer spu_id;

    @ApiModelProperty(value = "品类id",required = false)
    @Column(name = "category_id")
    private Integer category_id;

    @ApiModelProperty(value = "品类名称",required = false)
    @Column(name = "category_name")
    private String category_name;

    @ApiModelProperty(value = "品牌名称",required = false)
    @Column(name = "brand_name")
    private String brand_name;

    @ApiModelProperty(value = "规格",required = false)
    @Column(name = "spec")
    private String spec;

    @ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
    private Integer sale_num;

    @ApiModelProperty(value = "评论数",required = false)
    @Column(name = "comment_num")
    private Integer comment_num;

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

    public Integer getAlert_num() {
        return alert_num;
    }

    public void setAlert_num(Integer alert_num) {
        this.alert_num = alert_num;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getSale_num() {
        return sale_num;
    }

    public void setSale_num(Integer sale_num) {
        this.sale_num = sale_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
