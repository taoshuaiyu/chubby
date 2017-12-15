package com.ctrlcvs.classLoader;

/**
 * @author tsy
 * @Description
 * @date 19:35 2017/12/14
 */
public class PrivateHero {

    // 英雄名称
    private String name;
    // 装备名称
    private String outfit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutfit() {
        return outfit;
    }

    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }

    public void say() {
        System.out.println(name + "购买了" + outfit);
    }
}
