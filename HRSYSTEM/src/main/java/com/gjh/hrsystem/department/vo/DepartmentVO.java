package com.gjh.hrsystem.department.vo;

import com.gjh.hrsystem.common.vo.DefaultVO;

public class DepartmentVO extends DefaultVO {

	private int depId;
	
	private String depCode;
	
	private String depNm;
	
	private String depUpdatedAte;

	
	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
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

	public String getDepUpdatedAte() {
		return depUpdatedAte;
	}

	public void setDepUpdatedAte(String depUpdatedAte) {
		this.depUpdatedAte = depUpdatedAte;
	}
}