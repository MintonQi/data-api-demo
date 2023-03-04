package com.minton.dataapi.service;

import com.minton.dataapi.entity.Ta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportService {
    public void save(List<Ta> cachedDataList);
}
