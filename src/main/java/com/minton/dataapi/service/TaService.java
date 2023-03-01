package com.minton.dataapi.service;

import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.entity.Ta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaService {
    private TaMapper taMapper;
    @Autowired
    public TaService(TaMapper taMapper){
        this.taMapper = taMapper;
    }


    public void addTa(Ta ta){
        taMapper.insertTa(ta);
    }

    public void deleteTaByA(String a) {
        taMapper.deleteTaByA(a);
    }
}
