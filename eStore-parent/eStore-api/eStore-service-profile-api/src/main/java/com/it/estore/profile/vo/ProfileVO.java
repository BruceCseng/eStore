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
 * @Date: 2020/11/16 下午9:48
 * @Description: com.it.estore.profile.vo
 * @Version: 1.0
 */
@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_profile")
public class ProfileVO implements Serializable {

    @ApiModelProperty(value = "简介编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "简介标题",required = false)
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "简介分类",required = false)
    @Column(name = "category_id")
    private Integer categoryId;

    @ApiModelProperty(value = "简介分类名称",required = false)
    @Column(name = "category_name")
    private String categoryName;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
