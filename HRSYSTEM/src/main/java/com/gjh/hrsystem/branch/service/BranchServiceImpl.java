package com.gjh.hrsystem.branch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjh.hrsystem.branch.vo.BranchVO;

@Service("branchService")
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchMapper branchMapper;

	@Override
	public List<BranchVO> selectBranchList(BranchVO vo) {

		return branchMapper.selectBranchList(vo);
	}
}