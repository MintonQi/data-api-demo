package com.minton.dataapi;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson2.JSON;
import com.minton.dataapi.controller.TaController;
import com.minton.dataapi.controller.TbController;
import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.dao.TbMapper;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.listener.TaReadListener;
import com.minton.dataapi.service.TaService;
import com.minton.dataapi.service.TbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DataApiApplicationTests {

	String PATH = "D:\\IDEA_Projects\\data-api\\A.xlsx";

	@Autowired
	private TaMapper taMapper;

	@Autowired
	private TaService taService;

	@Autowired
	private TaController taController;

	@Autowired
	private TbMapper tbMapper;

	@Autowired
	private TbService tbService;

	@Autowired
	private TbController tbController;

	@Test
	void contextLoads() {
	}

	@Test
	void testTAMapper(){
		Ta ta = taMapper.selectTaByA("A0001A");
		ta.setCc(1);
		taMapper.updateTa(ta.getA(), ta);
//		try {
//			taMapper.insertTA(ta);
//		} catch (Exception e){
//			System.out.println(e);
//			System.out.println("got you");
//		}
	}

	@Test
	void testTAController(){
		Ta ta = new Ta();
		ta.setA("33333");
		taController.addTa(ta);
	}

	@Test
	public void test1(){
//		EasyExcel.read("D:\\IDEA_Projects\\data-api\\A.xlsx", Ta.class, new PageReadListener<Ta>(dataList -> {
//			for (Ta ta : dataList) {
//				System.out.println(JSON.toJSONString(ta));
//			}
//		})).sheet().doRead();

//		EasyExcel.read("D:\\IDEA_Projects\\data-api\\A.xlsx", Ta.class, new TaReadListener(taService)).sheet().doRead();


	}

	@Test
	void testTbMapper(){
		Ta ta = taMapper.selectTaByA("A0001A");
		ta.setA("666");
		tbService.insertTb(ta);
//		tbMapper.deleteTbByAC("A0001A", "A");
//		ta.setCc(1);
//		tbService.updateTb(ta.getA(), ta);
	}
}
