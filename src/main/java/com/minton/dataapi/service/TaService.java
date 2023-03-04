package com.minton.dataapi.service;

import com.alibaba.excel.EasyExcel;
import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.listener.TaReadListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TaService {
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

    public void addTa(Ta ta){
        taMapper.insertTa(ta);
        tbMapper.caculateTb(ta.getA());
    }

    public void deleteTaByA(String a) {
        taMapper.deleteTaByA(a);
        tbMapper.caculateTb(a);
    }

    public void updateTa(String a, Ta ta) {
        taMapper.updateTa(a, ta);
        tbMapper.caculateTb(a);
    }

    public List<Ta> fuzzySearchByA(String a) {
        return taMapper.fuzzySearchByA(a);
    }

    public void save(List<Ta> cachedDataList) {
        for(Ta ta : cachedDataList){
            this.addTa(ta);
        }
    }
}
