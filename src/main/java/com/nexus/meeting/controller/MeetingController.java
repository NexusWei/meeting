package com.nexus.meeting.controller;

import com.nexus.meeting.model.Department;
import com.nexus.meeting.model.Employee;
import com.nexus.meeting.model.Meeting;
import com.nexus.meeting.model.MeetingRoom;
import com.nexus.meeting.service.DepartmentService;
import com.nexus.meeting.service.EmployeeService;
import com.nexus.meeting.service.MeetingRoomService;
import com.nexus.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class MeetingController {

    // 每页默认显示的数量
    public static final Integer PAGE_SIZE = 5;

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeService.getEmpsByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession httpSession) {
        Employee currentuser = (Employee) httpSession.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting, mps);
        if (result == 1) {
            return "redirect:/admin/searchmeetings";
        }else {
            return "forward:/bookmeeting";
        }
    }

    @RequestMapping("/searchmeetings")
    public String searchmeetings(@RequestParam(required = false) Date reservationtimefrom, @RequestParam(required = false) Date reservationtimeto, Employee employee, MeetingRoom meetingroom, Meeting meeting, Model model, @RequestParam(defaultValue = "1") Integer page) {
        List<Meeting> meetings = meetingService.getAllMeetings(reservationtimefrom, reservationtimeto, employee, meetingroom, meeting, page, PAGE_SIZE);
        Long total = meetingService.getTotal(reservationtimefrom, reservationtimeto, employee, meeting, meetingroom);
        model.addAttribute("meetings", meetings);
        model.addAttribute("meetingroom", meetingroom);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("reservationtimefrom", reservationtimefrom);
        model.addAttribute("reservationtimeto", reservationtimeto);
        model.addAttribute("pagenum", total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);

        return "searchmeetings";
    }

    @RequestMapping("/meetingdetails")
    public String meetingdetails() {
        return "meetingdetails";
    }
}
