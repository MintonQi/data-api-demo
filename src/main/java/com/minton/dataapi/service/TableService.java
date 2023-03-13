package com.minton.dataapi.service;

import com.minton.dataapi.entity.Ta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {

    void addTa(Ta ta);

    void updateTa(String a, Ta ta);

    void save(List<Ta> cachedDataList);




}
