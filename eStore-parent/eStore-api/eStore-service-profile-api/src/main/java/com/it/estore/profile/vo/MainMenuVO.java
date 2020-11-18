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
 * @Date: 2020/11/16 下午9:47
 * @Description: com.it.estore.profile.vo
 * @Version: 1.0
 */
@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_main_menu")
public class MainMenuVO implements Serializable {

    @ApiModelProperty(value = "主目录编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "目录名称",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "目录跳转路由",required = false)
    @Column(name = "href")
    private String href;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
