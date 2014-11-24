package com.iamsee.valuebean;

public class baseinfo {

	public int id;
	public String name;
	public String shortname;
	public String sex;
	public String birth;
	public String hometowndes;
	public String idcard;
	public String worktime;
	public String unittime;
	public String orgid;
	public String deptid;
	public String orguid;
	public String postname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHometowndes() {
		return hometowndes;
	}

	public void setHometowndes(String hometowndes) {
		this.hometowndes = hometowndes;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getUnittime() {
		return unittime;
	}

	public void setUnittime(String unittime) {
		this.unittime = unittime;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getOrguid() {
		return orguid;
	}

	public void setOrguid(String orguid) {
		this.orguid = orguid;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public baseinfo() {

	}

	public baseinfo(int id, String name, String shortname, String sex,
			String birth, String hometowndes, String idcard, String worktime,
			String postname) {
		super();

		this.id = id;

		this.name = name;
		this.shortname = shortname;
		this.sex = sex;
		this.birth = birth;
		this.hometowndes = hometowndes;
		this.idcard = idcard;
		this.worktime = worktime;
		this.postname = postname;
	}

}
