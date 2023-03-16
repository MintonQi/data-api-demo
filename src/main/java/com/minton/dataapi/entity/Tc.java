package com.minton.dataapi.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Tc {

    @ExcelProperty("B")
    private String b;

    @ExcelProperty("aaS")
    private String aaS;

    @ExcelProperty("bbS")
    private String bbS;
    @ExcelProperty("ccS")
    private String ccS;
    @ExcelProperty("aaA")
    private String aaA;
    @ExcelProperty("bbA")
    private String bbA;
    @ExcelProperty("ccA")
    private String ccA;
    @ExcelProperty("aaSS")
    private String aaSS;
    @ExcelProperty("aaC")
    private String aaC;
    @ExcelProperty("ddS")
    private String ddS;

}
