package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer updatestatus(@Param("employeeid") Integer employeeid,@Param("status") Integer status);

    List<Employee> getAllEmps(@Param("employee") Employee employee, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    Long getTotal(Employee employee);

    List<Employee> getEmpsByDepId(Integer depId);

    Integer updatePassWord(@Param("newpassword") String newpassword, @Param("employeeid") Integer employeeid, @Param("password") String password);
}
