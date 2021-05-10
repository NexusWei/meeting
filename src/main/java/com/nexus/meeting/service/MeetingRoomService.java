package com.nexus.meeting.service;

import com.nexus.meeting.mapper.MeetingRoomMapper;
import com.nexus.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }
}
