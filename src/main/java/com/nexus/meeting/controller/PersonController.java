package com.nexus.meeting.controller;

import com.nexus.meeting.model.Employee;
import com.nexus.meeting.service.EmployeeService;
import com.nexus.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class PersonController {

    // 每页默认显示的数量
    public static final Integer PAGE_SIZE = 5;

    @Autowired
    MeetingService meetingService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/mymeetings")
    public String mymeetings(Model model, HttpSession httpSession, @RequestParam(defaultValue = "1") Integer page) {
        // 获取session中的employeeid，然后传递给后端，根据employeeid查询
        Employee currentuser = (Employee) httpSession.getAttribute("currentuser");
        Integer employeeid = currentuser.getEmployeeid();

        // 这两句效果完全相同，不同的写法
        // model.addAttribute("meetings", meetingService.getMeetingByEmployeeId(((Employee) httpSession.getAttribute("currentuser")).getEmployeeid(), page, PAGE_SIZE));
        model.addAttribute("meetings", meetingService.getMeetingByEmployeeId(employeeid, page, PAGE_SIZE));

        Long total = meetingService.getTotalMeetingByEmployeeId(employeeid);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum", total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);
        return "mymeetings";
    }

    @RequestMapping("mybookings")
    public String mybookings(Model model, HttpSession httpSession) {
        model.addAttribute("meetings", meetingService.getBookingByEmployeeId(((Employee) httpSession.getAttribute("currentuser")).getEmployeeid()));
        return "mybookings";
    }

    @RequestMapping("mymeetingdetails")
    public String mymeetingdetails(Integer meetingid, Model model) {
        model.addAttribute("mt", meetingService.getMeetingById(meetingid));
        model.addAttribute("emps", meetingService.getEmployeeByMeetingId(meetingid));
        return "mymeetingdetails";
    }

    @RequestMapping("cancelmeeting")
    public String cancelmeeting(Integer meetingid, Model model) {
        model.addAttribute("mt", meetingService.getMeetingById(meetingid));
        return "cancelmeeting";
    }

    @PostMapping("docancelmeeting")
    public String docancelmeeting(Integer meetingid, String cancelreason) {
        Integer result = meetingService.updatemeeting(meetingid, cancelreason);
        if (result >= 1) {
            return "redirect:/admin/mybookings";
        }else {
            return "cancelmeeting";
        }
    }

    @RequestMapping("changepassword")
    public String changepassword() {
        return "changepassword";
    }

    @PostMapping("dochangepassword")
    public String dochangepassword(String newpassword, String password, HttpSession httpSession, Model model) {
        Integer result = employeeService.updatePassWord(newpassword, ((Employee) httpSession.getAttribute("currentuser")).getEmployeeid(), password);
        System.out.println(result);
        if (result == 1) {
            return "redirect:/";
        }else {
            model.addAttribute("error", "密码修改失败，请检查原密码是否正确");
            return "changepassword";
        }
    }
}
