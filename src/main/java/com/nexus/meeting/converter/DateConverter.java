package com.nexus.meeting.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Date convert(String source) {
        // 先判断一下，如果source等于空，直接返回null，避免出现 Unparseable date: ""
        if (source != "") {
            try {
                return sdf.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }else {
            return null;
        }
    }
}
