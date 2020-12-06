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
@Table(name = "tb_message")
public class MessageVO implements Serializable {

    @ApiModelProperty(value = "消息编号",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "姓名",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "邮箱",required = false)
    @Column(name = "email")
    private String email;

    @ApiModelProperty(value = "手机号",required = false)
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "留言消息",required = false)
    @Column(name = "message")
    private String message;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
