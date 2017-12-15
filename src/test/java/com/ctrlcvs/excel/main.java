package com.ctrlcvs.excel;

import java.io.File;

/**
 * @author tsy
 * @Description
 * @date 16:35 2017/12/15
 */
public class main {
    public static void main(String[] args) throws Exception {
        ExcelWrapper<user> ew = ExcelImportUtil.excelToClass("D:\\tt.xlsx", user.class);
        ew.getList().forEach(System.out::println);
    }
}
