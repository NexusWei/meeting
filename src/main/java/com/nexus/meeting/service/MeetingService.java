package com.nexus.meeting.service;

import com.nexus.meeting.mapper.MeetingMapper;
import com.nexus.meeting.model.Employee;
import com.nexus.meeting.model.Meeting;
import com.nexus.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    MeetingMapper meetingMapper;

    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }

    public List<Meeting> getAllMeetings(Employee employee, MeetingRoom meetingroom, Meeting meeting, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return meetingMapper.getAllMeetings(employee, meetingroom, meeting, page, pageSize);
    }

    public Long getTotal(Employee employee, Meeting meeting, MeetingRoom meetingRoom) {
        return meetingMapper.getTotal(employee, meeting, meetingRoom);
    }
}
