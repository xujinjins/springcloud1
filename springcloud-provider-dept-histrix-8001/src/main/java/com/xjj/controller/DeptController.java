package com.xjj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xjj.domain.Dept;
import com.xjj.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //日志记录器
     Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept getById(@PathVariable Long id){
        logger.debug("哈哈哈");
        return deptService.findById(id);
    }



    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "exceptionMethod")//定义服务熔断跳转的方法
    public List<Dept> list(){
        if(1==1){
            throw  new RuntimeException("没错，我就是要抛异常");
        }
        return deptService.findAll();
    }

    //异常处理方法
    public List<Dept> exceptionMethod(){
        List<Dept> lists = new ArrayList<>();
        lists.add(new Dept().setDeptno(100000L).setDname("服务器熔断信息").setDb_source("服务异常"));
        return lists;
    }
}
