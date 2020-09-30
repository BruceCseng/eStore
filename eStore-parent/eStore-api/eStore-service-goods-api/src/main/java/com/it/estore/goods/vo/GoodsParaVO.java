package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_para")
public class GoodsParaVO {

    @ApiModelProperty(value = "参数编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "名称",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "选项",required = false)
    @Column(name = "options")
    private String options;

    @ApiModelProperty(value = "排序",required = false)
    @Column(name = "sort")
    private Integer sort;

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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
