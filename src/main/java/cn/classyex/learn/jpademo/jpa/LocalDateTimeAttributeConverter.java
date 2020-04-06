package cn.classyex.learn.jpademo.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static cn.classyex.learn.jpademo.common.Const.BEIJING_ZONE;

/**
 * @date 2020/4/6 16:51 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : new Date(locDateTime.toInstant(BEIJING_ZONE).toEpochMilli()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        }
        return Instant.ofEpochMilli(date.getTime()).atZone(BEIJING_ZONE).toLocalDateTime();
    }
}
