package com.it.estore.profile.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/16 下午9:43
 * @Description: com.it.estore.profile.vo
 * @Version: 1.0
 */
@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_career")
public class CareerVO implements Serializable {

    @ApiModelProperty(value = "职业生涯编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "职业生涯标题",required = false)
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "职业生涯描述",required = false)
    @Column(name = "career_desc")
    private String desc;

    @ApiModelProperty(value = "评价者图片",required = false)
    @Column(name = "comment_image")
    private String commentImage;

    @ApiModelProperty(value = "评价人",required = false)
    @Column(name = "comment_person")
    private String commentPerson;

    @ApiModelProperty(value = "评价",required = false)
    @Column(name = "comment_desc")
    private String commentDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public String getCommentPerson() {
        return commentPerson;
    }

    public void setCommentPerson(String commentPerson) {
        this.commentPerson = commentPerson;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }
}
