package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingid") Integer meetingid,@Param("mps") Integer[] mps);

    List<Meeting> getAllMeetings();
}
