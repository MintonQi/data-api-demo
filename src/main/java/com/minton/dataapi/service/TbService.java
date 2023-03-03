package com.minton.dataapi.service;


import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbService {


    private TbMapper tbMapper;

    @Autowired
    public TbService(TbMapper tbMapper){
        this.tbMapper = tbMapper;
    }

    public void insertTb(Ta ta){
        tbMapper.insertTb(ta);
        tbMapper.caculateTb(ta.getA());
    }

    public void deleteTaByC(String c) {
        tbMapper.deleteTbByC(c);
    }

    public void updateTb(String a, Ta ta) {
        tbMapper.updateTb(a, ta);
        tbMapper.caculateTb(a);
    }



}
