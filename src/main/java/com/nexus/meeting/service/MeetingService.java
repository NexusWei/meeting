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

    public List<Meeting> getAllMeetings(Date reservationtimefrom, Date reservationtimeto, Employee employee, MeetingRoom meetingroom, Meeting meeting, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return meetingMapper.getAllMeetings(reservationtimefrom, reservationtimeto, employee, meetingroom, meeting, page, pageSize);
    }

    public Long getTotal(Date reservationtimefrom, Date reservationtimeto, Employee employee, Meeting meeting, MeetingRoom meetingRoom) {
        return meetingMapper.getTotal(reservationtimefrom, reservationtimeto, employee, meeting, meetingRoom);
    }

    public Meeting getMeetingById(Integer meetingid){
        return meetingMapper.getMeetingById(meetingid);
    }

    public List<Employee> getEmployeeByMeetingId(Integer meetingid) {
        return meetingMapper.getEmployeeByMeetingId(meetingid);
    }

    public List<Meeting> getMeetingByEmployeeId(Integer meetingid, Integer page, Integer pageSize) {
        page = (page -1) * pageSize;
        return meetingMapper.getMeetingByEmployeeId(meetingid, page, pageSize);
    }

    public Long getTotalMeetingByEmployeeId(Integer employeeid) {
        return meetingMapper.getTotalMeetingByEmployeeId(employeeid);
    }

    public List<Meeting> getBookingByEmployeeId(Integer meetingid) {
        return meetingMapper.getBookingByEmployeeId(meetingid);
    }

    public Integer updatemeeting(Integer meetingid, String cancelreason) {
        return meetingMapper.updatemeeting(meetingid, cancelreason);
    }
}
