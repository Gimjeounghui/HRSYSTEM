package com.gjh.hrsystem.employee.service;

import java.util.List;

import com.gjh.hrsystem.employee.vo.EmployeeVO;

public interface EmployeeService {
	
	public List<EmployeeVO> selectEmployeeList(EmployeeVO vo);
	
}