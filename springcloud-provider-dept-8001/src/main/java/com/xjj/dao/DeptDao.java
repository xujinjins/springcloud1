package com.xjj.dao;

import com.xjj.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

     boolean addDept(Dept dept);

     Dept findById(Long id);

     List<Dept> findAll();
}
