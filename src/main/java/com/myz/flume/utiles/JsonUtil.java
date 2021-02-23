package com.myz.flume.utiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myz.flume.common.CustomException;
import com.myz.flume.common.ResponseBean;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new CustomException(ResponseBean.SERIAL_ERROR.getCode(), "序列化失败", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String s, Class<?> clasz) {
        try {
            return (T) MAPPER.readValue(s, clasz);
        } catch (Exception e) {
            throw new CustomException(ResponseBean.DESERIAL_ERROR.getCode(), "反序列化失败", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String s, @SuppressWarnings("rawtypes") TypeReference ref) {
        try {
            return (T) MAPPER.readValue(s, ref);
        } catch (Exception e) {
            throw new CustomException(ResponseBean.TOJSON_ERROR.getCode(),"转换失败",e);
        }
    }

    public static Map<String, Object> getObjectToMap(Object obj)  {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }
}
