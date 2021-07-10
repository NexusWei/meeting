package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Employee;
import com.nexus.meeting.model.Meeting;
import com.nexus.meeting.model.MeetingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingid") Integer meetingid,@Param("mps") Integer[] mps);

    List<Meeting> getAllMeetings(@Param("reservationtimefrom") Date reservationtimefrom, @Param("reservationtimeto") Date reservationtimeto, @Param("employee") Employee employee, @Param("meetingroom") MeetingRoom meetingroom, @Param("meeting") Meeting meeting, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    Long getTotal(@Param("reservationtimefrom") Date reservationtimefrom, @Param("reservationtimeto") Date reservationtimeto, @Param("employee") Employee employee, @Param("meeting") Meeting meeting, @Param("meetingroom") MeetingRoom meetingroom);
}
