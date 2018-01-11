package com.ctrlcvs.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author tsy
 * @Description
 * @date 10:03 2017/12/20
 */
public class ExcelExportUtil {

    public void export() throws Exception {
        // 使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        Workbook workbook = ExcelImportUtil.getHssfOrXssfWorkBook("D:\\tt.xls");
        Sheet sheet = workbook.getSheetAt(0);
        // 确定标题行以及字段对应列
        Iterator<Row> rows = sheet.rowIterator();
        while (rows.hasNext()) {
            Row row = rows.next();
            int colNums = row.getLastCellNum();
            for (int i = 0; i < colNums; i++) {
                Cell cell = row.getCell(i);
                String value = ExcelImportUtil.getStringCellValue(cell);
                // TODO 如果不是list
                if (value.contains("hua") && !value.contains("[]")) {
                    cell.setCellValue(parser.parseExpression("#baseModel.name").getValue(context,
                            String.class));
                }
                // TODO 如果是list 向下
                if (value.contains("hua") && value.contains("[up]")) {
                    // TODO 根据属性名去取集合 遍历集合
                    Object obj = new Object();
                    List list = (List) getFieldValueByName("集合属性名称", obj);
                    for (int j = 0; j < list.size(); j++) {
                        Row rowList = sheet.createRow(row.getRowNum() + j);
                        rowList.getCell(i).setCellValue(parser.parseExpression("#baseModel.name")
                                .getValue(context, String.class));
                    }
                    cell.setCellValue(parser.parseExpression("#baseModel.list[j]").getValue(context,
                            String.class));
                }
            }
        }

    }

    /**
     * 根据属性名获取属性值
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
