package com.minton.dataapi;

import com.minton.dataapi.dao.TAMapper;
import com.minton.dataapi.entity.TA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

@SpringBootTest
class DataApiApplicationTests {

	@Autowired
	private TAMapper taMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testTAMapper(){
		TA ta = taMapper.selectTAByA("A0001A");
		System.out.println(ta.getAa());
		ta.setA(null);
//		taMapper.insertTA(ta);
		try {
			taMapper.insertTA(ta);
		} catch (Exception e){
			System.out.println(e);
			System.out.println("got you");
		}
	}



}
