package com.nexus.meeting.controller;

import com.nexus.meeting.model.Department;
import com.nexus.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/admin")
public class DepartmentController {
    /* 搭建项目时测试的部分，不需要了，注释掉

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dep")
    public void getDepById(Integer id) {
        Department dep = departmentService.getDepById(id);
        System.out.println("dep" + dep);
    }
     */

    @RequestMapping("/departments")
    public String departments() {
        return "departments";
    }

}
