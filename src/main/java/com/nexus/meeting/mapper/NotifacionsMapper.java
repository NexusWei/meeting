package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Meeting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotifacionsMapper {
    List<Meeting> getMeetingByData(Integer employeeid);

    List<Meeting> getMeetingByStatus(Integer employeeid);
}
