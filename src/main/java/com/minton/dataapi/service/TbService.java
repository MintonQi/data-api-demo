package com.minton.dataapi.service;


import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TbService implements TableService {


    private TbMapper tbMapper;

    @Autowired
    public TbService(TbMapper tbMapper){
        this.tbMapper = tbMapper;
    }

    public void addTa(Ta ta){
        tbMapper.insertTb(ta);
        tbMapper.caculateTb(ta.getA());
    }

    public void deleteTbByC(String c) {
        tbMapper.deleteTbByC(c);
    }

    public void deleteTbByAC(String a, String c){
        tbMapper.deleteTbByAC(a, c);
    }

    @Override
    @Transactional
    public void updateTa(String a, Ta ta) {
        tbMapper.updateTb(a, ta);
        tbMapper.caculateTb(a);
    }

    @Override
    public void save(List<Ta> cachedDataList) {
        for(Ta ta : cachedDataList){
            this.addTa(ta);
        }
    }

}
