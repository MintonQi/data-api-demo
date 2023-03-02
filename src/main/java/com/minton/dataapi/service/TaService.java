package com.minton.dataapi.service;

import com.alibaba.excel.EasyExcel;
import com.minton.dataapi.dao.TaMapper;
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

    public void importTaExcel(MultipartFile ta_excel) throws IOException {
        EasyExcel.read(ta_excel.getInputStream(), Ta.class, new TaReadListener(taMapper)).sheet().doRead();
    }
}
