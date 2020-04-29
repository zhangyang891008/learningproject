package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("emp")
public class Emp {

    private String empNo;
    private String empName;
    private Integer empAge;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                '}';
    }
}
