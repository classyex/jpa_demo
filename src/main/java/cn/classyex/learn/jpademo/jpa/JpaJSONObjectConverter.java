package cn.classyex.learn.jpademo.jpa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @date 2020/4/6 16:52 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@Converter
public class JpaJSONObjectConverter implements AttributeConverter<JSONObject, String> {

    @Override
    public String convertToDatabaseColumn(JSONObject meta) {
        return null == meta ? null : JSON.toJSONString(meta);
    }

    @Override
    public JSONObject convertToEntityAttribute(String dbData) {
        return Strings.isNullOrEmpty(dbData) ? null : JSON.parseObject(dbData, new TypeReference<JSONObject>() {
        });
    }
}
