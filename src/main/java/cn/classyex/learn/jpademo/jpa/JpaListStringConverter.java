package cn.classyex.learn.jpademo.jpa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

/**
 * @date 2020/4/6 16:51 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@Converter
public class JpaListStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> meta) {
        return JSON.toJSONString(CollectionUtils.isEmpty(meta) ? Collections.emptyList() : meta);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Strings.isNullOrEmpty(dbData) ? Lists.newArrayList() : JSON.parseObject(dbData, new TypeReference<List<String>>() {
        });
    }
}
