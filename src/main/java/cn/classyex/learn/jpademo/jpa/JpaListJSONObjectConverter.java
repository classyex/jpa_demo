package cn.classyex.learn.jpademo.jpa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

/**
 * @date 2020/4/6 16:52 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@Converter
public class JpaListJSONObjectConverter implements AttributeConverter<List<Object>, String> {

    @Override
    public String convertToDatabaseColumn(List<Object> meta) {
        return CollectionUtils.isEmpty(meta) ? null : JSON.toJSONString(meta);
    }

    @Override
    public List<Object> convertToEntityAttribute(String dbData) {
        return Strings.isNullOrEmpty(dbData) ? null : JSON.parseObject(dbData, new TypeReference<List<Object>>() {
        });
    }
}
