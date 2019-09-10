package com.xjj.controller;

import com.xjj.service.DeptService;
import com.xjj.domain.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

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
    public List<Dept> list(){
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/discover",method = RequestMethod.GET)
    public Object discover(){
        List<String> list = client.getServices();
        System.out.println("****"+list);
        List<ServiceInstance> srvlist = client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance s : srvlist){
            System.out.println(s.getHost()+s.getServiceId()+s.getPort()+s.getUri()+s.isSecure());
        }
        return this.client;
    }
}
