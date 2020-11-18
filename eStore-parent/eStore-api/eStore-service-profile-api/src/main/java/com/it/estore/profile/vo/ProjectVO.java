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
 * @Date: 2020/11/16 下午9:51
 * @Description: com.it.estore.profile.vo
 * @Version: 1.0
 */
@ApiModel(description = "Bruce", value = "Bruce")
@Table(name = "tb_project")
public class ProjectVO implements Serializable {

    @ApiModelProperty(value = "项目编号", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "项目名称", required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "项目图片地址", required = false)
    @Column(name = "image_url")
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
