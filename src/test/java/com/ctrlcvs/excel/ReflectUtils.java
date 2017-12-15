package com.ctrlcvs.excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常用的正则表达式
 * @author tsy
 */
public class ReflectUtils {

    private ReflectUtils() {
    }

    /**
     * 获取成员变量的修饰符
     * @param clazz class类
     * @param field 属性
     * @param <T> 泛型
     * @return 成员变量的修饰符
     * @throws Exception
     */
    public static <T> int getFieldModifier(Class<T> clazz, String field) {
        // getDeclaredFields可以获取所有修饰符的成员变量，包括private,protected等getFields则不可以
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                return fields[i].getModifiers();
            }
        }
        throw new RuntimeException(clazz + " has no field \"" + field + "\"");
    }

    /**
     * 获取成员方法的修饰符
     * @param clazz class类
     * @param method 方法
     * @param <T> 泛型
     * @return 成员方法的修饰符
     * @throws Exception
     */
    public static <T> int getMethodModifier(Class<T> clazz, String method) {

        // getDeclaredMethods可以获取所有修饰符的成员方法，包括private,protected等getMethods则不可以
        Method[] m = clazz.getDeclaredMethods();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals(method)) {
                return m[i].getModifiers();
            }
        }
        throw new RuntimeException(clazz + " has no method \"" + method + "\"");
    }

    /**
     * [类]根据成员变量名称获取其值（默认值）
     * @param clazz class类
     * @param field 属性
     * @param <T> 泛型
     * @return 变量值
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> Object getFieldValue(Class<T> clazz, String field)
            throws IllegalAccessException, InstantiationException {

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(field)) {
                // 对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
                fields[i].setAccessible(true);
                return fields[i].get(clazz.newInstance());
            }
        }

        return null;
    }

    /**
     * 获取所有的成员变量(通过GET，SET方法获取)
     * @param clazz class类
     * @param <T> 泛型
     * @return 成员变量
     */
    public static <T> String[] getFields(Class<T> clazz) {

        Field[] fields = clazz.getDeclaredFields();

        String[] fieldsArray = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fieldsArray[i] = fields[i].getName();
        }
        return fieldsArray;
    }

    /**
     * 获取所有的成员变量,包括父类
     * @param clazz class类
     * @param superClass 是否包括父类
     * @param <T> 泛型
     * @return 所有的成员变量
     * @throws Exception
     */
    public static <T> Field[] getFields(Class<T> clazz, boolean superClass) {

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = null;
        if (superClass) {
            Class<?> superClazz = clazz.getSuperclass();
            if (superClazz != null) {
                superFields = superClazz.getDeclaredFields();
            }
        }

        Field[] allFields = null;

        if (superFields == null || superFields.length == 0) {
            allFields = fields;
        } else {
            allFields = new Field[fields.length + superFields.length];
            for (int i = 0; i < fields.length; i++) {
                allFields[i] = fields[i];
            }
            for (int i = 0; i < superFields.length; i++) {
                allFields[fields.length + i] = superFields[i];
            }
        }

        return allFields;
    }

    /**
     * 获取所有的成员变量,包括父类
     * @param clazz class类
     * @param <T> 泛型
     * @return 所有的成员变量
     * @throws Exception
     */
    public static <T> Field[] getClassFieldsAndSuperClassFields(Class<T> clazz) {

        Field[] fields = clazz.getDeclaredFields();

        if (clazz.getSuperclass() == null) {
//            throw new BizRuntimeException(clazz.getName() + "没有父类");
        }

        Field[] superFields = clazz.getSuperclass().getDeclaredFields();

        Field[] allFields = new Field[fields.length + superFields.length];

        for (int i = 0; i < fields.length; i++) {
            allFields[i] = fields[i];
        }
        for (int i = 0; i < superFields.length; i++) {
            allFields[fields.length + i] = superFields[i];
        }

        return allFields;
    }

    /**
     * 指定类，调用指定的方法
     * @param clazz 类
     * @param method 方法
     * @param paramClasses 参数类
     * @param params 参数
     * @param <T> 泛型
     * @return Object 对象
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <T> Object invoke(Class<T> clazz, String method, Class<T>[] paramClasses,
            Object[] params) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Object instance = clazz.newInstance();
        Method m = clazz.getMethod(method, paramClasses);
        return m.invoke(instance, params);
    }

    /**
     * 通过类的实例，调用指定的方法
     * @param clazzInstance 实体
     * @param method 方法
     * @param paramClasses 参数
     * @param params 参数
     * @param <T> 实体
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @return 信息
     */
    public static <T> Object invoke(Object clazzInstance, String method, Class<T>[] paramClasses,
            Object[] params)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method m = clazzInstance.getClass().getMethod(method, paramClasses);
        return m.invoke(clazzInstance, params);
    }

    /**
     * @Description 获取一个类所有字段（含继承字段）
     * @author linb 2017年6月5日 下午8:31:59
     * @param clazz 类型
     * @return 字段列表
     */
    public static List<Field> getFileds(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        if (null == clazz) {
            return list;
        }
        if (null != clazz.getSuperclass()) {
            list.addAll(getFileds(clazz.getSuperclass()));
        }
        // 获取所有字段（包括private）
        Field[] fields = clazz.getDeclaredFields();
        if (null != fields) {
            list.addAll(Arrays.asList(fields));
        }

        return list;
    }
}
