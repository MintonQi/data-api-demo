package com.minton.dataapi.controller;

import com.minton.dataapi.entity.TA;
import com.minton.dataapi.service.TAService;
import com.minton.dataapi.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ta")
public class TAController {

    private TAService taService;

    @Autowired
    public TAController(TAService taService){
        this.taService = taService;
    }

    @PostMapping("")
    public ResultInfo addTA(@RequestBody TA ta){
        try{
            taService.addTable(ta);
            return ResultInfo.success(ta);
        } catch (DuplicateKeyException e) {
            return ResultInfo.error(400,"此A字段的值已存在");
        } catch (Exception e){
            return ResultInfo.error(500, "未知服务器错误");
        }
    }

}
