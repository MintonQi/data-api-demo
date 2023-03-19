package com.minton.dataapi.service;


import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.entity.Tb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class TbService implements TableService {


    private TbMapper tbMapper;

    private ThreadPoolExecutor executor;

    @Autowired
    public TbService(TbMapper tbMapper, ThreadPoolExecutor executor){
        this.tbMapper = tbMapper;
        this.executor = executor;
    }

    @Override
    public void addTa(Ta ta) {
        tbMapper.insertTb(ta);
    }

    //    @Transactional
    @Override
    public void batchInsertTa(List<Ta> taList){

        Thread thread = new Thread(() -> {
            try{
                long start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"开始导入数据");
                tbMapper.batchInsertTb(taList);
                System.out.println(Thread.currentThread().getName()+"完成batchInsert，花费时间"+(System.currentTimeMillis()-start));
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        try{
            executor.execute(thread);
        }catch (Exception e){
            e.printStackTrace();
        }

//        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
//        TbMapper tbMapper = sqlSession.getMapper(TbMapper.class);
//
//        try{
//            tbMapper.batchInsertTb(taList);
//            System.out.println("batchInsert finished");
//            sqlSession.commit();
//        }catch(Exception e){
//            System.out.println("批量导入数据异常，事务回滚");
//            e.printStackTrace();
//            sqlSession.rollback();
//        }
//
//        tbMapper.batchInsertTb(taList);

    }

    public int deleteTbByC(String c) {
        return tbMapper.deleteTbByC(c);
    }

    public int deleteTbByAC(String a, String c){
        return tbMapper.deleteTbByAC(a, c);
    }

    @Override
//    @Transactional
    public void updateTa(String a, Ta ta) {
        tbMapper.updateTb(a, ta);
//        tbMapper.calculateTb(a);
    }

    @Override
    public void save(List<Ta> cachedDataList) {
        this.batchInsertTa(cachedDataList);
    }

    public List<Tb> findTbs() {
        tbMapper.calculateTbs();
        return tbMapper.selectTbs();
    }

    public Tb selectTbByAC(String a, String c){
        return tbMapper.selectTbByAC(a,c);
    }


    public void calculateTbs(){
        tbMapper.calculateTbs();
    }
}
