package com.gjh.hrsystem.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjh.hrsystem.department.vo.DepartmentVO;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentVO> selectDepartmentList(DepartmentVO vo) {

		return departmentMapper.selectDepartmentList(vo);
	}
}
