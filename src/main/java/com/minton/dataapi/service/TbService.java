package com.minton.dataapi.service;


import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
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

    @Transactional
    public void addTa(Ta ta){
        tbMapper.insertTb(ta);
        tbMapper.calculateTb(ta.getA());
    }

    public int deleteTbByC(String c) {
        return tbMapper.deleteTbByC(c);
    }

    public int deleteTbByAC(String a, String c){
        return tbMapper.deleteTbByAC(a, c);
    }

    @Override
    @Transactional
    public void updateTa(String a, Ta ta) {
        tbMapper.updateTb(a, ta);
        tbMapper.calculateTb(a);
    }

    @Override
    public void save(List<Ta> cachedDataList) {
        for(Ta ta : cachedDataList){
            this.addTa(ta);
        }
    }

    public List<Tb> findTbs() {
        tbMapper.calculateTbs();
        return tbMapper.selectTbs();
    }

    public Tb selectTbByAC(String a, String c){
        return tbMapper.selectTbByAC(a,c);
    }




}
