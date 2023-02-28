package com.minton.dataapi;

import com.minton.dataapi.controller.TaController;
import com.minton.dataapi.dao.TaMapper;
import com.minton.dataapi.entity.Ta;
import com.minton.dataapi.service.TaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataApiApplicationTests {

	@Autowired
	private TaMapper taMapper;

	@Autowired
	private TaService taService;

	@Autowired
	private TaController taController;

	@Test
	void contextLoads() {
	}

	@Test
	void testTAMapper(){
//		Ta ta = taMapper.selectTAByA("A0001A");
//		System.out.println(ta.getAa());
//		ta.setA(null);
////		taMapper.insertTA(ta);
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



}
