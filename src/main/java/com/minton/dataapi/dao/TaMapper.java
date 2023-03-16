package com.minton.dataapi.dao;

import com.minton.dataapi.entity.Ta;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaMapper {
    Ta selectTaByA(String a);

    void insertTa(Ta ta);

    void deleteTaByA(String a);

    void updateTa(String a, Ta ta);

    List<Ta> fuzzySearchTaByA(String a);

    void save(List<Ta> cachedDataList);

    List<Ta> selectTas();
}
