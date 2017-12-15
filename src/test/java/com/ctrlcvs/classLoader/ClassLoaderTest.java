package com.ctrlcvs.classLoader;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author tsy
 * @Description
 * @date 19:15 2017/12/14
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchFieldException, NoSuchMethodException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // System.out.println("current loader:" + classLoader);
        // System.out.println("parent loader:" + classLoader.getParent());
        // System.out.println("grandparent loader:" +
        // classLoader.getParent().getParent());
        Class<?> clazz = classLoader.loadClass("com.ctrlcvs.classLoader.PrivateHero");

        Constructor<?> cons = clazz.getDeclaredConstructor((Class[]) null);
        PrivateHero hero = (PrivateHero) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        // 取消Java语言访问检查以访问private变量
        name.setAccessible(true);
        name.set(hero, "德玛西亚之力");

        Field outfit = clazz.getDeclaredField("outfit");
        outfit.setAccessible(true);
        outfit.set(hero, "神盾");
        hero.say();
    }
}
