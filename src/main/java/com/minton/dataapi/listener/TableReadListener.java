package com.minton.dataapi.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.minton.dataapi.service.TableService;
import com.minton.dataapi.entity.Ta;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TableReadListener implements ReadListener<Ta> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<Ta> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private TableService tableService;

    private int saveCount = 0;
    private long timestamp = System.currentTimeMillis();
    private final long initialTimeStamp = System.currentTimeMillis();
    public TableReadListener(TableService tableService){
        this.tableService = tableService;
    }


    @Override
    public void invoke(Ta ta, AnalysisContext analysisContext) {

//        log.info("解析到一条数据:{}", JSON.toJSONString(ta));
        cachedDataList.add(ta);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            saveCount++;
            System.out.println("从上次清理至今耗时"+(System.currentTimeMillis()-timestamp));
            timestamp = System.currentTimeMillis();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        // 但是最好判断是否为空list
        if(cachedDataList.size() > 0){
            saveData();
        }
        log.info("所有数据解析完成！耗时"+(System.currentTimeMillis()-initialTimeStamp));

    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
//        System.out.println("ahhhhhhhhhhhh!");
        long start = System.currentTimeMillis();
        log.info("{}条数据，试图开线程存储数据库！", cachedDataList.size());
        tableService.save(cachedDataList);
        log.info("save() called, 耗时"+ (System.currentTimeMillis()-start));
    }
}
