package com.nexus.meeting.controller;

import com.nexus.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ApproveaccountController {

    public static final Integer PENDING_APPROVE = 0;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/approveaccount")
    public String approveaccount(Model model) {
        model.addAttribute("emps", employeeService.getAllEmpsByStatus(PENDING_APPROVE));
        return "approveaccount";
    }

    @RequestMapping("/updatestatus")
    public String updatestatus(Integer employeeid, Integer status) {
        employeeService.updatestatus(employeeid, status);
        // 审批通过或审批不通过，都返回审批页面。
        return "redirect:/admin/approveaccount";
    }
}
