package com.ovs.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Candidate {
	String eid;
	String fname;
	String mname;
	String lname;
	String sex;
	String bdate;
	double uid;
	double phone;
	String email;
	String partyname;
	String electiondate;
	String conteststate;
	String contestdistrict;
	String contestsubdistrict;
	String candidateid;
	String electiontype;
	
	public Candidate(){
//	default constructor	
	}
	
	public Candidate(String eid, String fname,
			String mname, String lname, String sex, String bdate, double uid,
			double phone, String email, String partyname, String electiondate, String conteststate,
			String contestdistrict, String contestsubdistrict, String candidateid, String electiontype) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.sex = sex;
		this.bdate = bdate;
		this.uid = uid;
		this.phone = phone;
		this.email = email;
		this.partyname = partyname;
		this.electiondate = electiondate;
		this.conteststate = conteststate;
		this.contestdistrict = contestdistrict;
		this.contestsubdistrict = contestsubdistrict;
		this.candidateid = candidateid;
		this.electiontype = electiontype;
	}
	@XmlElement(name="eid")
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	@XmlElement(name="fname")
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@XmlElement(name="mname")
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@XmlElement(name="lname")
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@XmlElement(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@XmlElement(name="bdate")
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	@XmlElement(name="uid")
	public double getUid() {
		return uid;
	}
	public void setUid(double uid) {
		this.uid = uid;
	}
	@XmlElement(name="phone")
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name="partyname")
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	@XmlElement(name="electiondate")
	public String getElectiondate() {
		return electiondate;
	}
	public void setElectiondate(String electiondate) {
		this.electiondate = electiondate;
	}
	@XmlElement(name="conteststate")
	public String getConteststate() {
		return conteststate;
	}
	public void setConteststate(String conteststate) {
		this.conteststate = conteststate;
	}
	@XmlElement(name="contestdistrict")
	public String getContestdistrict() {
		return contestdistrict;
	}
	public void setContestdistrict(String contestdistrict) {
		this.contestdistrict = contestdistrict;
	}
	@XmlElement(name="contestsubdistrict")
	public String getContestsubdistrict() {
		return contestsubdistrict;
	}
	public void setContestsubdistrict(String contestsubdistrict) {
		this.contestsubdistrict = contestsubdistrict;
	}
	@XmlElement(name="candidateid")
	public String getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}
	@XmlElement(name="electiontype")
	public String getElectiontype() {
		return electiontype;
	}
	public void setElectiontype(String electiontype) {
		this.electiontype = electiontype;
	}
}