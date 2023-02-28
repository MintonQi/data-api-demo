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
        System.out.println(ta.getA());
        System.out.println(ta.getB());
        System.out.println(ta.getAa());
        System.out.println(ResultInfo.success(ta));
        try{
            taService.addTable(ta);
            return ResultInfo.success(ta);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return ResultInfo.error(400,"此A字段的值已存在！");
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return ResultInfo.error(400, "A字段不能为空！");
        } catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error(500, "未知服务器错误");
        }
    }

}
