package com.nexus.meeting.controller;

import com.nexus.meeting.model.Employee;
import com.nexus.meeting.service.NotifacionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class NotificationsController {

    @Autowired
    NotifacionsService notifacionsService;

    @RequestMapping("/notifications")
    public String notifications(Model model, HttpSession httpSession) {
        Integer employeeid = ((Employee) httpSession.getAttribute("currentuser")).getEmployeeid();
        model.addAttribute("meetings", notifacionsService.getMeetingByData(employeeid));
        model.addAttribute("mts", notifacionsService.getMeetingByStatus(employeeid));
        return "notifications";
    }

}
