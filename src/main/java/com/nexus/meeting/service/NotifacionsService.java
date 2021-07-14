package com.nexus.meeting.service;

import com.nexus.meeting.mapper.NotifacionsMapper;
import com.nexus.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifacionsService {

    @Autowired
    NotifacionsMapper notifacionsMapper;

    public List<Meeting> getMeetingByData(Integer employeeid){
        return notifacionsMapper.getMeetingByData(employeeid);
    }

    public List<Meeting> getMeetingByStatus(Integer employeeid){
        return notifacionsMapper.getMeetingByStatus(employeeid);
    }
}
