package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "student")
@Validated
public class Student {
    private String name;
    private Integer age;
    private List<String> hobbies;
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sleep;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
    private Date date;

    public DataSize getDataSize() {
        return dataSize;
    }

    public void setDataSize(DataSize dataSize) {
        this.dataSize = dataSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getSleep() {
        return sleep;
    }

    public void setSleep(Duration sleep) {
        this.sleep = sleep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", sleep=" + sleep +
                ", dataSize=" + dataSize +
                ", date=" + date +
                '}';
    }
}
