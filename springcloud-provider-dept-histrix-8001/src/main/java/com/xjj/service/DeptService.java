package com.xjj.service;

import com.xjj.domain.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptService {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
