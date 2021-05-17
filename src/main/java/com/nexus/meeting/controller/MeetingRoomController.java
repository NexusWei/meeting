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

    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model) {
        model.addAttribute("mr", meetingRoomService.getMrById(roomid));
        return "roomdetails";
    }

    @RequestMapping("/updateroom")
    public String updateroom(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.updateroom(meetingRoom);
        if (result == 1) {
            return "redirect:/admin/meetingrooms";
        }else {
            return "forward:/roomdetails";
        }
    }

    @RequestMapping("/addmeetingroom")
    public String addmeetingroom() {
        return "addmeetingroom";
    }

    @RequestMapping("doAddMr")
    public String doAddMr(MeetingRoom meetingRoom, Model model) {
        meetingRoomService.addMr(meetingRoom);
        return "redirect:/admin/meetingrooms";
    }
}
