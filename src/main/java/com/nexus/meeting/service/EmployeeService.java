package com.nexus.meeting.service;

import com.nexus.meeting.mapper.EmployeeMapper;
import com.nexus.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUsername(username);
        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }
        return employee;
    }

    public Integer doReg(Employee employee) {
        // 注册时根据用户名从数据库获取用户
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        // 如果存在用户，则用户名重复，不能注册。
        if (emp != null) {
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }
}
