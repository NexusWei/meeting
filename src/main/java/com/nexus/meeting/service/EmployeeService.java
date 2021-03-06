package com.nexus.meeting.service;

import com.nexus.meeting.mapper.EmployeeMapper;
import com.nexus.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // 根据状态查询所有待审批用户
    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    // 根据id更新审批状态
    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.updatestatus(employeeid, status);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        page = (page -1) * pageSize;
        return employeeMapper.getAllEmps(employee, page, pageSize);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }

    public Integer updatePassWord(String newpassword, Integer employeeid, String password) {
        return employeeMapper.updatePassWord(newpassword, employeeid, password);
    }
}
