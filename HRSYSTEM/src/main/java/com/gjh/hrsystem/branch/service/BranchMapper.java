package com.gjh.hrsystem.branch.service;

import java.util.List;

import com.gjh.hrsystem.branch.vo.BranchVO;

public interface BranchMapper {

	public List<BranchVO> selectBranchList(BranchVO vo);
	
}