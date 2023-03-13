package com.minton.dataapi.controller;

import com.alibaba.excel.EasyExcel;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import com.minton.dataapi.listener.TableReadListener;
import com.minton.dataapi.service.TbService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/tb")
public class TbController {

    private TbService tbService;

    @Autowired
    public TbController(TbService tbService){
        this.tbService = tbService;
    }

    @GetMapping()
    public ResultInfo selectTb(@PathVariable String a, @PathVariable String c){
        tbService.findTbs();
        return ResultInfo.success();
    }

    @PostMapping
    public ResultInfo addTb(@RequestBody Ta ta){
        try{
            tbService.addTa(ta);
            return ResultInfo.success(ta);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return ResultInfo.error(4001,"此A字段的值已存在！");
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return ResultInfo.error(4002, "A字段不能为空！");
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(500, "未知错误");
        }
    }

    @PutMapping("/{a}")
    public ResultInfo updateTa(@PathVariable("a") String a, @RequestBody Ta ta){
        try{
            ta.setA(a);
            tbService.updateTa(a, ta);
            return ResultInfo.success();
        } catch(Exception e){
            e.printStackTrace();
            return ResultInfo.error(5000,"未知错误");
        }
    }

    @DeleteMapping("/{c}")
    public ResultInfo deleteTbByC(@PathVariable("c") String c){
        try{
            tbService.deleteTbByC(c);
            return ResultInfo.success();
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error();
        }
    }

    @DeleteMapping("/{a}/{c}")
    public ResultInfo deleteTbByAC(@PathVariable("a") String a, @PathVariable("c") String c){
        try{
            tbService.deleteTbByAC(a, c);
            return ResultInfo.success();
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error();
        }
    }

    @PutMapping("/excel")
    public ResultInfo importTaExcel(MultipartFile ta_excel) throws IOException {
        EasyExcel.read(ta_excel.getInputStream(), Ta.class, new TableReadListener(tbService)).sheet().doRead();
        return ResultInfo.success();
    }


    @GetMapping("/excel")
    public ResultInfo exportTbExcel(){

        List<Tb> list = tbService.findTbs();
        //先写死吧这个路径，，，
        EasyExcel.write("D:\\IDEA_Projects\\data-api\\TbLists.xlsx", Tb.class).sheet("Sheet1").doWrite(list);
        return ResultInfo.success();
    }



}
