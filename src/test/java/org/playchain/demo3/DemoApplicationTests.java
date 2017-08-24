package org.playchain.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.playchain.demo3.mapper.PermissionMapper;
import org.playchain.demo3.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	PermissionMapper permissionMapper;

	@Test
	public void contextLoads() {

		List<Permission> permissionList = permissionMapper.selectPermissionByUserId(2);
		logger.info(permissionList.toString());
	}

}
