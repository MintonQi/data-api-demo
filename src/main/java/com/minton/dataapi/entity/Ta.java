package com.minton.dataapi.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Ta {
    @ExcelProperty(index = 0)
    private String a;
    @ExcelProperty(index = 1)
    private String b;
    @ExcelProperty(index = 2)
    private String c;
    @ExcelProperty(index = 3)
    private String d;
    @ExcelProperty(index = 4)
    private String e;
    @ExcelProperty(index = 5)
    private String f;
    @ExcelProperty(index = 6)
    private Integer aa;
    @ExcelProperty(index = 7)
    private Integer bb;
    @ExcelProperty(index = 8)
    private Integer cc;
    @ExcelProperty(index = 9)
    private Integer dd;
    @ExcelProperty(index = 10)
    private Integer ee;
}

