package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);
}
