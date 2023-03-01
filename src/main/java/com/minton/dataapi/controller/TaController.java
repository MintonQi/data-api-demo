package com.minton.dataapi.controller;

import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.service.TaService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

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
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return ResultInfo.error(4002, "A字段不能为空！");
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(500, "未知错误");
        }
    }

    @DeleteMapping("/{a}")
    public ResultInfo deleteTaByA(@PathVariable("a") String a){
        try{
            System.out.println(a);
            taService.deleteTaByA(a);
            return ResultInfo.success();
        } catch (Exception e){
            System.out.println(a);
            e.printStackTrace();
            return ResultInfo.error(4003, "此A字段值的记录不存在！");
        }



    }

}
