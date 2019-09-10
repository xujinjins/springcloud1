package com.xjj.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    Long deptno;
    String dname;
    String db_source;

    public  Dept(String dname){
        super();
        this.dname = dname;
    }

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(11L).setDname("RD").setDb_source("DB01");//链式写法
        System.out.println(dept.toString());
    }
}
