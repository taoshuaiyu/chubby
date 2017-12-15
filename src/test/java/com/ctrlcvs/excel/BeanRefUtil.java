package com.ctrlcvs.excel;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description excel导入导出处理工具类
 * @author tsy
 * @date 2017年6月7日 下午2:52:37
 */
public class BeanRefUtil {

    private static final Logger LOG = LoggerFactory.getLogger(BeanRefUtil.class);

    /**
     * set属性的值到Bean
     * @param valMap
     */
    public static List<ExcelException> setFieldValue(int rowNum, Object model, List<Field> fields,
            Map<String, String> valMap, Map<String, Integer> colMap) {
        List<ExcelException> exceptionList = new ArrayList<>();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                String value = valMap.get(fieldName);
                if (StringUtils.isNotBlank(value)) {
                    field.setAccessible(true); // 使得可操作private
                    Class<?> fieldType = field.getType();
                    if (String.class.equals(fieldType)) {
                        field.set(model, value);
                    } else if (Date.class.equals(fieldType)) {
                        Date temp = parseDate(value);
                        field.set(model, temp);
                    } else if (Integer.class.equals(fieldType) || int.class.equals(fieldType)) {
                        Integer intval = Integer.valueOf(value);
                        field.set(model, intval);
                    } else if (Long.class.equals(fieldType) || long.class.equals(fieldType)) {
                        Long temp = Long.parseLong(value);
                        field.set(model, temp);
                    } else if (Double.class.equals(fieldType) || double.class.equals(fieldType)) {
                        Double temp = Double.parseDouble(value);
                        field.set(model, temp);
                    } else if (Boolean.class.equals(fieldType) || boolean.class.equals(fieldType)) {
                        Boolean temp = Boolean.parseBoolean(value);
                        field.set(model, temp);
                    } else {
                        LOG.error("------------------ fieldType not exists : " + fieldType);
                    }
                }
            } catch (Exception e) {
                LOG.error("", e);
                exceptionList.add(new ExcelException(rowNum, null, e.getMessage()));
            }
        }
        return exceptionList;
    }

    /**
     * 格式化string为Date
     * @param datestr
     * @return date
     */
    private static Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy.MM.dd HH:mm";
            } else {
                fmtstr = "yyyy.MM.dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr);
            sdf.setLenient(false);
            return sdf.parse(datestr);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
}