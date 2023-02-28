package com.minton.dataapi.dao;

import com.minton.dataapi.entity.TA;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TAMapper {

    TA selectTAByA(String A);
    void insertTA(TA ta);


}
