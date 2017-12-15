package com.ctrlcvs.excel;

/**
 * @author tsy
 * @Description
 * @date 16:33 2017/12/15
 */
public class user {

    @Excel(value = "姓名")
    private String name;

    @Excel(value = "年龄")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
