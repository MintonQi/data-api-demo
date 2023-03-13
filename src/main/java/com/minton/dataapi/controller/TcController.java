package com.minton.dataapi.controller;

import com.alibaba.excel.EasyExcel;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import com.minton.dataapi.entity.Tc;
import com.minton.dataapi.service.TcService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tc")
public class TcController {

    private TcService tcService;

    @Autowired
    public TcController(TcService tcService){
        this.tcService = tcService;
    }

    @GetMapping("/{b}")
    public ResultInfo fuzzySearchTcByB(@PathVariable String b){
        try {
            List<Tc> list_tc = tcService.fuzzySearchByB(b);
            return ResultInfo.success(list_tc);
        } catch(Exception e){
            e.printStackTrace();
            return ResultInfo.error(5000, "未知错误");
        }
    }

    @PutMapping
    public ResultInfo calculateTc(){
        try{
            tcService.calculateTc();
            return ResultInfo.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(5000, "未知错误");
        }

    }

    @GetMapping("/excel")
    public ResultInfo exportTc(){
        List<Tc> list = tcService.findTcs();
        //先写死吧这个路径，，，
        EasyExcel.write("D:\\IDEA_Projects\\data-api\\TcLists.xlsx", Tc.class).sheet("Sheet1").doWrite(list);
        return ResultInfo.success();
    }

}
