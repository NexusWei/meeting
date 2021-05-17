package com.nexus.meeting.mapper;

import com.nexus.meeting.model.MeetingRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingRoomMapper {
    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateroom(MeetingRoom meetingRoom);

    Integer addMr(MeetingRoom meetingRoom);
}
