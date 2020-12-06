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
 * @Date: 2020/11/16 下午9:35
 * @Description: com.it.estore.profile.vo
 * @Version: 1.0
 */
@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_content")
public class ContentVO implements Serializable {

    @ApiModelProperty(value = "关于我编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "关于我标题",required = false)
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "关于我描述",required = false)
    @Column(name = "about_desc")
    private String desc;

    @ApiModelProperty(value = "关于我URL",required = false)
    @Column(name = "url")
    private String url;

    @ApiModelProperty(value = "关于我技能",required = false)
    @Column(name = "skill")
    private String skill;

    @ApiModelProperty(value = "关于我技能掌握度",required = false)
    @Column(name = "skill_value")
    private String skillValue;

    @ApiModelProperty(value = "关于我技能描述",required = false)
    @Column(name = "skill_desc")
    private String skillDesc;

    @ApiModelProperty(value = "关于我技能图片",required = false)
    @Column(name = "skill_image")
    private String skillImage;

    @ApiModelProperty(value = "关于我类型",required = false)
    @Column(name = "type")
    private String type;

    @ApiModelProperty(value = "所属目录",required = false)
    @Column(name = "parent_id")
    private Integer parentId;

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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillValue() {
        return skillValue;
    }

    public void setSkillValue(String skillValue) {
        this.skillValue = skillValue;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public String getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(String skillImage) {
        this.skillImage = skillImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
