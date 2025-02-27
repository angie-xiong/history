package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.RedisDao;

/**
 * How to do unit test in spring-boot
 * @author anqi.xiong
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest /*(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
public class SpringbootDemoApplicationTests {
	
	public static Logger logger= LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);
	
	@Test
	public void contextLoads() {
		
	}
	
	@Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","forezp");
        redisDao.setKey("age","11");
        logger.debug(redisDao.getValue("name"));
        logger.debug(redisDao.getValue("age"));
    }

}
