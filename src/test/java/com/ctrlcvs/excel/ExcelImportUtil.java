package com.ctrlcvs.excel;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tsy
 * @Description
 * @date 14:18 2017/12/15
 */
public class ExcelImportUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelImportUtil.class);

    private ExcelImportUtil() {

    }

    public static <T> ExcelWrapper<T> excelToClass(String filePath, Class<T> clazz)
            throws Exception {
        Workbook workbook = getHssfOrXssfWorkBook(filePath);
        return getInfoByAnnotation(clazz, workbook);
    }

    private static <T> ExcelWrapper<T> getInfoByAnnotation(Class<T> clazz, Workbook workbook)
            throws IllegalAccessException, InstantiationException {
        ExcelWrapper<T> excelWrapper = new ExcelWrapper<>();
        List<ExcelException> exceptionList = new ArrayList<>();
        List<T> list = new ArrayList<T>();
        // 字段名到列号的映射
        Map<String, Integer> colMap = new HashMap<>();
        // 列对应字段名到该行的值的映射
        Map<String, String> valMap = new HashMap<String, String>();
        // 标题行字段名列表
        Map<Integer, String> keyMap = new HashMap<>();
        // 获取类的所有字段（含继承字段）
        List<Field> fields = ReflectUtils.getFileds(clazz);
        fields = fields.stream().filter(u -> u.isAnnotationPresent(Excel.class))
                .collect(Collectors.toList());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        List<Boolean> flag = new ArrayList<>();
        while (rows.hasNext()) {
            // 获取每行数据
            Row row = rows.next();
            // 获取每行的最后一列的列数
            int colNum = row.getLastCellNum();
            if (CollectionUtils.isEmpty(flag)) {
                for (int i = 0; i < colNum; i++) {
                    Cell cell = row.getCell(i);
                    String value = getStringCellValue(cell);
                    fields.stream()
                            .filter(u -> u.isAnnotationPresent(Excel.class)
                                    && value.matches(u.getAnnotation(Excel.class).value()))
                            .forEach(f -> {
                                keyMap.put(cell.getColumnIndex(), f.getName());
                                colMap.put(f.getName(), cell.getColumnIndex());
                                flag.add(true);
                            });
                }
            } else {
                List<Boolean> isBlankLine = new ArrayList<>();
                keyMap.forEach((k, v) -> {
                    Cell cell = row.getCell(k);
                    String value = getStringCellValue(cell);
                    valMap.put(keyMap.get(k), value);
                    if (StringUtils.isBlank(value)) {
                        isBlankLine.add(true);
                    }
                });
                if (CollectionUtils.isNotEmpty(isBlankLine)) {
                    continue;
                }
                // 初始化对象
                T model = clazz.newInstance();
                // TODO 校验数据 如果校验有异常 直接返回 不需要反射
                // 导入数据到model，并校验要求
                List<ExcelException> exceptions = BeanRefUtil.setFieldValue(row.getRowNum(), model,
                        fields, valMap, colMap);
                list.add(model);
                exceptionList.addAll(exceptions);
            }
        }
        excelWrapper.setExceptionList(exceptionList);
        excelWrapper.setList(list);
        excelWrapper.setColMap(colMap);
        return excelWrapper;
    }

    /**
     * 获取Workbook
     * @param filePath 文件路径
     * @return Excel
     * @throws Exception 异常
     */
    public static Workbook getHssfOrXssfWorkBook(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在 ");
        }
        FileInputStream fis = new FileInputStream(filePath);
        try {
            return new HSSFWorkbook(fis);
        } catch (Exception e) {
            LOG.debug("", e);
            fis = new FileInputStream(file);
            return new XSSFWorkbook(fis);
        }
    }

    /**
     * @Description 获取单元格数据内容为字符串类型的数据
     * @param cell 单元格
     * @return 字符串类型的数据
     */
    public static String getStringCellValue(Cell cell) {
        String strCell = "";
        if (null != cell) {
            CellType cellType = cell.getCellTypeEnum();
            if (CellType.STRING.equals(cellType)) {
                strCell = cell.getStringCellValue();
            } else if (CellType.NUMERIC.equals(cellType)) {
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    strCell = df.format(date);
                } else {
                    strCell = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
            } else if (CellType.BOOLEAN.equals(cellType)) {
                strCell = String.valueOf(cell.getBooleanCellValue());
            } else if (CellType.BLANK.equals(cellType)) {
                strCell = "";
            } else {
                strCell = "";
            }
        }
        if ("".equals(strCell) || strCell == null) {
            return "";
        }
        // 忽略两边空格
        strCell = strCell.trim();
        return strCell;
    }
}
