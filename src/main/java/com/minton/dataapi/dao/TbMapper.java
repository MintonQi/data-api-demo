package com.minton.dataapi.dao;

import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbMapper{

    void insertTb(Ta ta);

    void deleteTbByAC(String a, String c);

    void deleteTbByC(String c);

    void updateTb(String a, Ta ta);

}
