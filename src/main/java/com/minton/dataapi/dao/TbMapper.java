package com.minton.dataapi.dao;

import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbMapper{

    List<Tb> selectTbs();

    void insertTb(Ta ta);
    void batchInsertTb(List<Ta> taList);

    int deleteTbByAC(String a, String c);

    int deleteTbByC(String c);

    void updateTb(String a, Ta ta);

    void calculateTb(String a);

    Tb selectTbByAC(String a, String c);

    void calculateTbs();
}
