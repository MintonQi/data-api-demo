package com.minton.dataapi.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Tc {

    @ExcelProperty("B")
    private String b;

    @ExcelProperty("aaS")
    private double aaS;

    @ExcelProperty("bbS")
    private double bbS;
    @ExcelProperty("ccS")
    private double ccS;
    @ExcelProperty("aaA")
    private double aaA;
    @ExcelProperty("bbA")
    private double bbA;
    @ExcelProperty("ccA")
    private double ccA;
    @ExcelProperty("aaSS")
    private double aaSS;
    @ExcelProperty("aaC")
    private double aaC;
    @ExcelProperty("ddS")
    private double ddS;

}
