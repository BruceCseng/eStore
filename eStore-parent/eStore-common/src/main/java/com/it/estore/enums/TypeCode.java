package com.it.estore.enums;

import java.io.Serializable;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/20 下午11:07
 * @Description: com.it.estore.utils
 * @Version: 1.0
 */
public enum TypeCode implements Serializable {

    H0_LEVEL("-1","插入招聘的级别"),
    // 标题级
    H1_LEVEL("0","标题级别"),

    H2_LEVEL("1","内容级别和H3_LEVEL并列"),

    H3_LEVEL("2","内容级别和H2_LEVEL并列"),

    H4_LEVEL("3","页面底部联系我等信息，无parentId");

    private String code;

    private String Type;

    TypeCode(String code, String type) {
        this.code = code;
        Type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
