package com.minton.dataapi.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.entity.Ta;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TaReadListener implements ReadListener<Ta> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<Ta> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private TaMapper taMapper;

    public TaReadListener(TaMapper taMapper){
        this.taMapper = taMapper;
    }


    @Override
    public void invoke(Ta ta, AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(ta));
        log.info("解析到一条数据:{}", JSON.toJSONString(ta));
        cachedDataList.add(ta);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
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
        saveData();
        log.info("所有数据解析完成！");
        System.out.println("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println("ahhhhhhhhhhhh!");
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//        taMapper.save(cachedDataList);
        for(Ta ta : cachedDataList){
            taMapper.insertTa(ta);
        }

        log.info("存储数据库成功！");
    }


}
