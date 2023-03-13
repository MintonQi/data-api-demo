package com.minton.dataapi.service;

import com.minton.dataapi.dao.TcMapper;
import com.minton.dataapi.entity.Tc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TcService {

    private TcMapper tcMapper;

    @Autowired
    public TcService(TcMapper tcMapper){
        this.tcMapper = tcMapper;
    }

    public List<Tc> fuzzySearchByB(String b){
        return tcMapper.fuzzySearchTcByB(b);
    }

    public void calculateTc(){
        tcMapper.clearTc();
        tcMapper.calculateTc();
    }

    public List<Tc> findTcs(){
        return tcMapper.selectTcs();
    }


}
