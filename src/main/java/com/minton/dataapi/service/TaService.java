package com.minton.dataapi.service;

import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaService implements TableService {
    private TaMapper taMapper;
    private TbMapper tbMapper;

    @Autowired
    public TaService(TaMapper taMapper, TbMapper tbMapper){
        this.taMapper = taMapper;
        this.tbMapper = tbMapper;
    }

    public Ta getTaByA(String a){
        return taMapper.selectTaByA(a);
    }

    @Override
    @Transactional
    public void addTa(Ta ta){
        taMapper.insertTa(ta);
        tbMapper.caculateTb(ta.getA());
    }

    @Transactional
    public void deleteTaByA(String a) {
        taMapper.deleteTaByA(a);
        tbMapper.caculateTb(a);
    }
    @Override
    @Transactional
    public void updateTa(String a, Ta ta) {
        taMapper.updateTa(a, ta);
        tbMapper.caculateTb(a);
    }

    public List<Ta> fuzzySearchByA(String a) {
        return taMapper.fuzzySearchByA(a);
    }

    @Override
    public void save(List<Ta> cachedDataList) {
        for(Ta ta : cachedDataList){
            this.addTa(ta);
        }
    }
}
