package com.gjh.hrsystem.department.service;

import java.util.List;

import com.gjh.hrsystem.department.vo.DepartmentVO;

public interface DepartmentService {

	public List<DepartmentVO>selectDepartmentList(DepartmentVO vo);
	
}

