package com.example.report;

import com.example.report.pojo.UserEntity;
import com.example.report.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReportApplicationTests {

	@Autowired
	private JwtUtil jwtUtil;

	@Test
	void contextLoads() {
		UserEntity user = new UserEntity(1, "test", "123456");
		String token = jwtUtil.generate(user);
		System.out.println(token);
		System.out.println(jwtUtil.validate(token));
	}

}
