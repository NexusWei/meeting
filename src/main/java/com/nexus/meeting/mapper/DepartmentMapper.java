package com.nexus.meeting.mapper;

import com.nexus.meeting.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    Department getDepById(Integer id);

    List<Department> getAllDeps();

    Integer adddepartment(String departmentname);

    Department getDepByName(String departmentname);

    Integer deletedep(Integer departmentid);

    Integer updatedep(@Param("id") Integer id, @Param("name") String name);
}
