package com.nexus.meeting.controller;

import com.nexus.meeting.model.Department;
import com.nexus.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/admin")
public class DepartmentController {
    /* 搭建项目时测试的部分，不需要了，注释掉
    @GetMapping("/dep")
    public void getDepById(Integer id) {
        Department dep = departmentService.getDepById(id);
        System.out.println("dep" + dep);
    }
     */

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("deps", departmentService.getAllDeps());
        return "departments";
    }

    @RequestMapping("/adddepartment")
    public String adddepartment(String departmentname) {
        departmentService.adddepartment(departmentname);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/deletedep")
    public String deletedep(Integer departmentid) {
        departmentService.deletedep(departmentid);
//        System.out.println(departmentid);
        return "redirect:/admin/departments";
    }
}
