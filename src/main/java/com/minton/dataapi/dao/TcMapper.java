package com.minton.dataapi.dao;

import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TcMapper {

    void clearTc();

    void calculateTc();

    List<Tc> fuzzySearchTcByB(String b);

    List<Tc> selectTcs();


}
