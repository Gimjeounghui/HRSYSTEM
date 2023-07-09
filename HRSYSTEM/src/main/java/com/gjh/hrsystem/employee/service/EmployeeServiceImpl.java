package com.gjh.hrsystem.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjh.hrsystem.employee.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeVO> selectEmployeeList(EmployeeVO vo) {

		return employeeMapper.selectEmployeeList(vo);
	}
}


