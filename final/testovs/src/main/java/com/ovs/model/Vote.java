package com.ovs.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Vote {
	String eid;
	String conteststate;
	String contestdistrict;
	String contestsubdistrict;
	String electiontype;
	String electiondate;
	int votecount;
	
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public Vote(String eid, String conteststate, String contestdistrict,
			String contestsubdistrict, String electiontype,
			String electiondate, int votecount) {
		super();
		this.eid = eid;
		this.conteststate = conteststate;
		this.contestdistrict = contestdistrict;
		this.contestsubdistrict = contestsubdistrict;
		this.electiontype = electiontype;
		this.electiondate = electiondate;
		this.votecount = votecount;
	}
	@XmlElement(name="eid")
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
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
	@XmlElement(name="electiontype")
	public String getElectiontype() {
		return electiontype;
	}
	public void setElectiontype(String electiontype) {
		this.electiontype = electiontype;
	}
	@XmlElement(name="electiondate")
	public Date getElectiondate() throws ParseException {
		return (Date) sdf.parse(electiondate);
	}
	public void setElectiondate(String electiondate) {
		this.electiondate = electiondate;
	}
	@XmlElement(name="votecount")
	public int getVotecount() {
		return votecount;
	}
	public void setVotecount(int votecount) {
		this.votecount = votecount;
	}
	
}