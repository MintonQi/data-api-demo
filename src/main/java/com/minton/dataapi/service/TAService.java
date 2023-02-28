package com.minton.dataapi.service;

import com.minton.dataapi.dao.TAMapper;
import com.minton.dataapi.entity.TA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TAService {
    private TAMapper taMapper;
    @Autowired
    public TAService(TAMapper taMapper){
        this.taMapper = taMapper;
    }



    public void addTable(TA ta){
        taMapper.insertTA(ta);
    }


}
