package com.minton.dataapi.controller;

import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.service.TbService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tb")
public class TbController {

    private TbService tbService;

    @Autowired
    public TbController(TbService tbService){
        this.tbService = tbService;
    }

    @PostMapping
    public ResultInfo addTa(@RequestBody Ta ta){
        try{
            tbService.insertTb(ta);
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



}
