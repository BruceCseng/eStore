package com.it.estore.user.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@ApiModel(description = "Bruce",value = "Bruce")
@Table(name = "tb_user")
public class UserVO {

    @ApiModelProperty(value = "用户名",required = false)
    @Id
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "密码",required = false)
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "手机号码",required = false)
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "注册邮箱",required = false)
    @Column(name = "email")
    private String email;

    @ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "created")
    private Date created;

    @ApiModelProperty(value = "修改时间",required = false)
    @Column(name = "updated")
    private Date updated;

    @ApiModelProperty(value = "会员来源",required = false)
    @Column(name = "source_type")
    private String sourceType;

    @ApiModelProperty(value = "昵称",required = false)
    @Column(name = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "真实姓名",required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "使用状态",required = false)
    @Column(name = "status")
    private String status;

    @ApiModelProperty(value = "头像",required = false)
    @Column(name = "head_pic")
    private String headPic;

    @ApiModelProperty(value = "qq号码",required = false)
    @Column(name = "qq")
    private String qq;

    @ApiModelProperty(value = "手机是否验证",required = false)
    @Column(name = "is_mobile_check")
    private String isMobileCheck;

    @ApiModelProperty(value = "邮箱是否验证",required = false)
    @Column(name = "is_email_check")
    private String isEmailCheck;

    @ApiModelProperty(value = "性别",required = false)
    @Column(name = "sex")
    private String sex;

    @ApiModelProperty(value = "会员等级",required = false)
    @Column(name = "user_level")
    private Integer userLevel;

    @ApiModelProperty(value = "会员积分",required = false)
    @Column(name = "points")
    private Integer points;

    @ApiModelProperty(value = "经验值",required = false)
    @Column(name = "experience_value")
    private Integer experienceValue;

    @ApiModelProperty(value = "生日",required = false)
    @Column(name = "birthday")
    private Date birthday;

    @ApiModelProperty(value = "最后登录时间",required = false)
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck;
    }

    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
