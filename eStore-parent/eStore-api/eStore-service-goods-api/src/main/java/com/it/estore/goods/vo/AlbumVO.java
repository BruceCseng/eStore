package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_album")
public class AlbumVO {

    @ApiModelProperty(value = "相册编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "相册标题",required = false)
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "相册封面图片",required = false)
    @Column(name = "image")
    private String image;

    @ApiModelProperty(value = "json格式的所有图片地址",required = false)
    @Column(name = "image_item")
    private String imageItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
    }
}
