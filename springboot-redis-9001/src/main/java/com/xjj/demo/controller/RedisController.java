package com.xjj.demo.controller;

import com.xjj.demo.dao.RedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis测试类
 */
@RestController
public class RedisController {
    public static Logger logger = LoggerFactory.getLogger(RedisController.class);


    @Autowired
    RedisDao redisDao;

    @RequestMapping(method = RequestMethod.GET, value = "/redis/test")
    public String testRedis() {

        redisDao.setKey("name","jerry");
        redisDao.setKey("age","11");

        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));

        return redisDao.getValue("name")+"  "+redisDao.getValue("age");
    }


}