package com.minton.dataapi.service;

import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.entity.Ta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaService {
    private TaMapper taMapper;
    @Autowired
    public TaService(TaMapper taMapper){
        this.taMapper = taMapper;
    }

    public Ta getTaByA(String a){
        return taMapper.selectTaByA(a);
    }

    public void addTa(Ta ta){
        taMapper.insertTa(ta);
    }

    public void deleteTaByA(String a) {
        taMapper.deleteTaByA(a);
    }

    public void updateTa(String a, Ta ta) {
        taMapper.updateTa(a, ta);
    }

    public List<Ta> fuzzySearchByA(String a) {
        return taMapper.fuzzySearchByA(a);
    }
}
