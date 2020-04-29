package com.example.converter;

import com.example.entity.Weight;
import org.springframework.core.convert.converter.Converter;
//自定义的Converter
public class WeightConverter implements Converter<String,Weight> {
    @Override
    public Weight convert(String s) {
        System.out.println("Weight converter is invoke.." + s);
        String[] split = s.split(";");
        if(split.length!=2){
            System.out.println("param size error!"+s);
            return null;
        }

        Weight weight = new Weight();
        weight.setNumber(Integer.valueOf(split[0]));
        weight.setUnit(split[1]);

        return weight;
    }
}
