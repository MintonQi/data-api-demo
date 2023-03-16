package com.minton.dataapi.controller;

import com.alibaba.excel.EasyExcel;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import com.minton.dataapi.listener.TableReadListener;
import com.minton.dataapi.service.TaService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ta")
public class TaController {

    private TaService taService;

    @Autowired
    public TaController(TaService taService){
        this.taService = taService;
    }

    @PostMapping
    public ResultInfo addTa(@RequestBody Ta ta){
        try{
            taService.addTa(ta);
            return ResultInfo.success(ta);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return ResultInfo.error(4001,"此A字段的值已存在！");
        } catch (DataIntegrityViolationException e){ // 处理得，，，可能不是很对。。。
            e.printStackTrace();
            return ResultInfo.error(4002, "A字段不能为空！");
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(500, "未知错误");
        }
    }

    @DeleteMapping("/{a}")
    public ResultInfo deleteTaByA(@PathVariable("a") String a){
        if(taService.getTaByA(a) != null){
            try{
                taService.deleteTaByA(a);
                return ResultInfo.success();
            } catch(Exception e){
                e.printStackTrace();
                return ResultInfo.error(5000,"未知错误");
            }
        } else {
            return ResultInfo.error(4003, "此A字段值的记录不存在！");
        }
    }

    @PutMapping("/{a}")
    public ResultInfo updateTa(@PathVariable("a") String a, @RequestBody Ta ta){
        try{
            ta.setA(a);
            taService.updateTa(a, ta);
            return ResultInfo.success();
        } catch(Exception e){
            e.printStackTrace();
            return ResultInfo.error(5000,"未知错误");
        }
    }

    @GetMapping("/{a}")
    public ResultInfo fuzzySearchByA(@PathVariable("a") String a){
        try {
            List<Ta> list_ta = taService.fuzzySearchByA(a);
            return ResultInfo.success(list_ta);
        } catch(Exception e){
            e.printStackTrace();
            return ResultInfo.error(5000, "未知错误");
        }
    }

    @Transactional
    @PostMapping("/excel")
    public ResultInfo importTaExcel(MultipartFile ta_excel) throws IOException {
        EasyExcel.read(ta_excel.getInputStream(), Ta.class, new TableReadListener(taService)).sheet().doRead();
        return ResultInfo.success("导入成功");
    }

    @Transactional
    @GetMapping("/excel")
    public ResultInfo exportTbExcel(){
        List<Ta> list = taService.findTas();
        //先写死吧这个路径，，，
        EasyExcel.write("D:\\IDEA_Projects\\data-api\\TaLists.xlsx", Ta.class).sheet("Sheet1").doWrite(list);
        return ResultInfo.success();
    }

}
