package com.enums;

/**
 * @ProjectName: Maven_test
 * @Package: com.enums
 * @ClassName: SysEnum
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/14 15:27
 * @Version: 1.0
 */
public enum  SysEnum {
    COUNT("count");
    private  String value;

    SysEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
