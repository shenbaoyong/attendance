package com.shenbaoyong.attendance.common.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Shen Baoyong on 2017/4/8.
 */
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String objectToJson(Object object){
        try{
            String string = MAPPER.writeValueAsString(object);
            return string;
        }catch (Exception e){
            logger.error("对象序列化成jaon失败", e);
        }
        return null;
    }

    public static <T> T jsonToPojo(String jsonData, Class<T> beanType){
        try{
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        }catch (Exception e){
            logger.error("json反序列化成对象失败", e);
        }
        return null;
    }

    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType){
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        }catch (Exception e){
            logger.error("json反序列化成list失败");
        }
        return null;
    }

    public static <T> T mapToPojo(Object object, Class<T> beanType){
        try{
            String string = MAPPER.writeValueAsString(object);
            T t = MAPPER.readValue(string, beanType);
        }catch (Exception e){
            logger.error("map装换成Pojo失败");
        }
        return null;
    }

}
