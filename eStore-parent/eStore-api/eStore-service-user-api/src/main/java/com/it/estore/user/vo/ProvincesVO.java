package com.it.estore.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_provinces")
public class ProvincesVO {

    @ApiModelProperty(value = "省份编号",required = false)
    @Id
    @Column(name = "provinceId")
    private String provinceId;

    @ApiModelProperty(value = "省份名称",required = false)
    @Column(name = "province")
    private String province;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
