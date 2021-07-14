package com.nexus.meeting.controller;

import com.nexus.meeting.model.Department;
import com.nexus.meeting.model.Employee;
import com.nexus.meeting.service.DepartmentService;
import com.nexus.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession httpSession) {

        Employee employee = employeeService.doLogin(username, password);
        if (employee == null) {
            model.addAttribute("error", "用户名或密码输入错误，登录失败");
            return "forward:/";
        }else if (employee.getStatus() == 0) {
            model.addAttribute("error", "用户待审批");
            return "forward:/";
        }else if (employee.getStatus() == 2) {
            model.addAttribute("error", "用户审批未通过");
            return "forward:/";
        }else {
            // currentuser的内容
            // Employee{employeeid=8, employeename='王晓华', username='wangxh', phone='13671075406', email='wang@qq.com', status=1, departmentid=1, password='1', role=1}
            httpSession.setAttribute("currentuser", employee);
            return "redirect:/admin/notifications";
        }
    }

    @RequestMapping("/register")
    public String register(Model model) {
        // 获取所有部门
        List<Department> deps = departmentService.getAllDeps();
        // 回显给前端
        model.addAttribute("deps", deps);
        return "register";
    }

    @RequestMapping("/doReg")
    public String doReg(Employee employee, Model model) {
        Integer result = employeeService.doReg(employee);
        if (result == 1) {
            return "redirect:/";
        }else {
            // 注册失败，数据回传
            model.addAttribute("error", "注册失败");
            // 传回注册信息
            model.addAttribute("employee", employee);
            return "forward:/register";
        }
    }
}
