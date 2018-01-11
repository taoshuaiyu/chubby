package com.ctrlcvs.excel;

/**
 * @author tsy
 * @Description
 * @date 16:35 2017/12/15
 */
public class main {
    public static void main(String[] args) throws Exception {
        ExcelWrapper<user> ew = ExcelImportUtil.excelToClass("D:\\tt.xls", user.class);
        ew.getList().forEach(System.out::println);
        String str ="北[\\s\\S]*平人";
        System.out.println("北平人12121".matches(str));
    }
}
