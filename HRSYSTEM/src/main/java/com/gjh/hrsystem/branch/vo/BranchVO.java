package com.gjh.hrsystem.branch.vo;

import com.gjh.hrsystem.common.vo.DefaultVO;

public class BranchVO extends DefaultVO {
	
	private int bnhNo;
	
	private String bnhLocation;
	
	private String depCode;
	
	private String depNm;
	
	private String bnhLandline;
	
	private String bnhBusinessHours;

	
	public int getBnhNo() {
		return bnhNo;
	}

	public void setBnhNo(int bnhNo) {
		this.bnhNo = bnhNo;
	}

	public String getBnhLocation() {
		return bnhLocation;
	}

	public void setBnhLocation(String bnhLocation) {
		this.bnhLocation = bnhLocation;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public String getBnhLandline() {
		return bnhLandline;
	}

	public void setBnhLandline(String bnhLandline) {
		this.bnhLandline = bnhLandline;
	}

	public String getBnhBusinessHours() {
		return bnhBusinessHours;
	}

	public void setBnhBusinessHours(String bnhBusinessHours) {
		this.bnhBusinessHours = bnhBusinessHours;
	}
}