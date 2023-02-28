package com.minton.dataapi.dao;

import com.minton.dataapi.entity.Ta;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaMapper {

    Ta selectTaByA(String A);
    void insertTa(Ta ta);


}
