package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_ENUMS_USING_TO_STRING;

public class JsonUtil {
    public static String getJsonSchema(Class clazz) throws IOException {
//        org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapper = new ObjectMapper();
        //There are other configuration options you can set.  This is the one I needed.
//        mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(WRITE_ENUMS_USING_TO_STRING, true);

        JsonSchema schema = mapper.generateJsonSchema(clazz);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
    }

    public static void main(String[] args) throws IOException {
//        String jsonSchema = getJsonSchema(PatientInfo.class);
//        System.out.println("jsonSchema");
//        System.out.println(jsonSchema);
    }

    public static List<JSONObject> listToPascalCase(List javaObjects){
        List<JSONObject> ret=new ArrayList<>();
        for (Object javaObject : javaObjects) {
            ret.add(toPascalCase(javaObject));
        }
        return ret;
    }

    public static JSONObject toPascalCase(Object javaObject) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(javaObject);
//        Class<?> aClass = jsonObject.getClass();
//        System.out.println("aClass");
//        System.out.println(aClass);
//        System.out.println("jsonObject");
//        System.out.println(jsonObject);

        JSONObject pascalCase = new JSONObject();
        jsonObject.forEach((key, val) -> {
//            java 第一个字符大写
//            toTitle java
//            to PascalCase
//            StringUtil.ToPascalCase(col.Name)
//            StringUtil
//            StringUtils.Pas
//            pascalCase.put(com.zucc.whatRubbish.util.StrUtil.toPascalCase(key), val);
            pascalCase.put(StrUtil.toPascalCase(key), val);
        });

//        System.out.println("pascalCase");
//        System.out.println(pascalCase);
        return pascalCase;
    }

}
