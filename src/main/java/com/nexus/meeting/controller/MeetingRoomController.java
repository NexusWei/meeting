package com.nexus.meeting.controller;

import com.nexus.meeting.model.MeetingRoom;
import com.nexus.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/meetingrooms")
    public String meetingrooms(Model model) {
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "meetingrooms";
    }
}
