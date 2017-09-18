package com.ctrlcvs.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author tsy
 * @Description
 * @date 10:05 2017/9/15
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
    // 临时变量保存flag值列表
    private String values;

    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        // 分割定义的有效值
        String[] value_arr = values.split(",");
        boolean isFlag = false;
        // 遍历比对有效值
        for (int i = 0; i < value_arr.length; i++) {
            // 存在一直跳出循环，赋值isFlag=true
            if (value_arr[i].equals(values)) {
                isFlag = true;
                break;
            }
        }
        // 返回是否存在boolean
        return isFlag;
    }
}
