package com.it.estore.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_template")
public class TemplateVO {

    @ApiModelProperty(value = "模板编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "名称",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "规格数量",required = false)
    @Column(name = "spec_num")
    private Integer specNum;

    @ApiModelProperty(value = "参数数量",required = false)
    @Column(name = "para_num")
    private Integer paraNum;

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

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    public Integer getParaNum() {
        return paraNum;
    }

    public void setParaNum(Integer paraNum) {
        this.paraNum = paraNum;
    }
}
