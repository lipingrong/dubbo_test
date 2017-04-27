package com.pingrong.core.common;

import org.springframework.core.convert.converter.Converter;

/**
 * 判断字符串是否为空或空字符串
 */
public class ConverterString implements Converter<String,String>{
    @Override
    public String convert(String s) {
        if (null != s){
            s = s.trim();
            if (!"".equals(s)){
                return s;
            }
        }
        return null;
    }
}
