package cn.classyex.learn.jpademo.jpa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

/**
 * @date 2020/4/6 16:52 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@Converter
public class JpaListLongConverter implements AttributeConverter<List<Long>, String> {

    @Override
    public String convertToDatabaseColumn(List<Long> meta) {
        return JSON.toJSONString(CollectionUtils.isEmpty(meta) ? Collections.emptyList() : meta);
    }

    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        return JSON.parseObject(Strings.isNullOrEmpty(dbData) ? "[]" : dbData, new TypeReference<List<Long>>() {
        });
    }
}
