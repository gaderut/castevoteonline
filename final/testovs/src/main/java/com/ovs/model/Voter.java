package com.ovs.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Voter {
	String electorfname;
	String electormname;
	String electorlname;
	String electorsex;
	String electorbdate;
	String electorstate;
	String electordistrict;
	String electorsubdistrict;
	String electorbirthplace;
	String electorrfname;
	String electorrmname;
	String electorrlname;
	String electorrelation;
	double electoruid;
	double electorphone;
	String electoremail;
	String electorpermenantaddress;
	String prmtAddElectorstate;
	String prmtAddElectordistrict;
	String prmtAddElectorsubdistrict;
	double electorpincode;
	String absentreason;
	String absentdescription;			
	String awaydate;
	String electorcurrentaddress;
	String currAddElectorstate;
	String currAddElectordistrict;
	String currAddElectorsubdistrict;
	double currelectorpincode;
	String voterid;
	
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public Voter(){
		
	};
	public Voter(String electorfname, String electormname,
			String electorlname, String electorsex, String electorbdate,
			String electorstate, String electordistrict,String electorsubdistrict, String electorbirthplace,
			String electorrfname, String electorrmname,
			String electorrlname, String electorrelation,
			double electoruid, double electorphone, String electoremail,
			String electorpermenantaddress, String prmtAddElectorstate,
			String prmtAddElectordistrict,
			String prmtAddElectorsubdistrict, double electorpincode,
			String absentreason, String absentdescription,
			String awaydate, String electorcurrentaddress,
			String currAddElectorstate, String currAddElectordistrict,
			String currAddElectorsubdistrict, double currelectorpincode, String voterid) {
		super();
		this.electorfname = electorfname;
		this.electormname = electormname;
		this.electorlname = electorlname;
		this.electorsex = electorsex;
		this.electorbdate = electorbdate;
		this.electorstate = electorstate;
		this.electordistrict = electordistrict;
		this.electorsubdistrict=electorsubdistrict;
		this.electorbirthplace = electorbirthplace;
		this.electorrfname = electorrfname;
		this.electorrmname = electorrmname;
		this.electorrlname = electorrlname;
		this.electorrelation = electorrelation;
		this.electoruid = electoruid;
		this.electorphone = electorphone;
		this.electoremail = electoremail;
		this.electorpermenantaddress = electorpermenantaddress;
		this.prmtAddElectorstate = prmtAddElectorstate;
		this.prmtAddElectordistrict = prmtAddElectordistrict;
		this.prmtAddElectorsubdistrict = prmtAddElectorsubdistrict;
		this.electorpincode = electorpincode;
		this.absentreason = absentreason;
		this.absentdescription = absentdescription;
		this.awaydate = awaydate;
		this.electorcurrentaddress = electorcurrentaddress;
		this.currAddElectorstate = currAddElectorstate;
		this.currAddElectordistrict = currAddElectordistrict;
		this.currAddElectorsubdistrict = currAddElectorsubdistrict;
		this.currelectorpincode = currelectorpincode;
		this.voterid = voterid;
	}
	@XmlElement(name="electorfname")
	public String getelectorfname() {
		return electorfname;
	}
	@XmlElement(name="electorfname")
	public void setelectorfname(String electorfname) {
		this.electorfname = electorfname;
	}
	@XmlElement(name="electormname")
	public String getelectormname() {
		return electormname;
	}
	@XmlElement(name="electormname")
	public void setelectormname(String electormname) {
		this.electormname = electormname;
	}
	@XmlElement(name="electorlname")
	public String getelectorlname() {
		return electorlname;
	}
	@XmlElement(name="electorlname")
	public void setelectorlname(String electorlname) {
		this.electorlname = electorlname;
	}
	@XmlElement(name="electorsex")
	public String getelectorsex() {
		return electorsex;
	}
	@XmlElement(name="electorsex")
	public void setelectorsex(String electorsex) {
		this.electorsex = electorsex;
	}
	@XmlElement(name="electorbdate")
	public String getelectorbdate() {
		return electorbdate;
	}
	@XmlElement(name="electorbdate")
	public void setelectorbdate(String electorbdate) {
		this.electorbdate = electorbdate;
	}
	@XmlElement(name="electorstate")
	public String getelectorstate() {
		return electorstate;
	}
	@XmlElement(name="electorstate")
	public void setelectorstate(String electorstate) {
		this.electorstate = electorstate;
	}
	@XmlElement(name="electordistrict")
	public String getelectordistrict() {
		return electordistrict;
	}
	@XmlElement(name="electordistrict")
	public void setelectordistrict(String electordistrict) {
		this.electordistrict = electordistrict;
	}
	@XmlElement(name="electorsubdistrict")
	public String getelectorsubdistrict() {
		return electorfname;
	}
	@XmlElement(name="electorsubdistrict")
	public void setelectorsubdistrict(String electorsubdistrict) {
		this.electorsubdistrict = electorsubdistrict;
	}
	@XmlElement(name="electorbirthplace")
	public String getelectorbirthplace() {
		return electorbirthplace;
	}
	@XmlElement(name="electorbirthplace")
	public void setelectorbirthplace(String electorbirthplace) {
		this.electorbirthplace = electorbirthplace;
	}
	@XmlElement(name="electorrfname")
	public String getelectorrfname() {
		return electorrfname;
	}
	@XmlElement(name="electorrfname")
	public void setelectorrfname(String electorrfname) {
		this.electorrfname = electorrfname;
	}
	@XmlElement(name="electorrmname")
	public String getelectorrmname() {
		return electorrmname;
	}
	@XmlElement(name="electorrmname")
	public void setelectorrmname(String electorrmname) {
		this.electorrmname = electorrmname;
	}
	@XmlElement(name="electorrlname")
	public String getelectorrlname() {
		return electorrlname;
	}
	@XmlElement(name="electorrlname")
	public void setelectorrlname(String electorrlname) {
		this.electorrlname = electorrlname;
	}
	@XmlElement(name="electorrelation")
	public String getelectorrelation() {
		return electorrelation;
	}
	@XmlElement(name="electorrelation")
	public void setelectorrelation(String electorrelation) {
		this.electorrelation = electorrelation;
	}
	@XmlElement(name="electoruid")
	public double getelectoruid() {
		return electoruid;
	}
	@XmlElement(name="electoruid")
	public void setelectoruid(double electoruid) {
		this.electoruid = electoruid;
	}
	@XmlElement(name="electorphone")
	public double getelectorphone() {
		return electorphone;
	}
	@XmlElement(name="electorphone")
	public void setelectorphone(double electorphone) {
		this.electorphone = electorphone;
	}
	@XmlElement(name="electoremail")
	public String getelectoremail() {
		return electoremail;
	}
	@XmlElement(name="electoremail")
	public void setelectoremail(String electoremail) {
		this.electoremail = electoremail;
	}
	@XmlElement(name="electorpermenantaddress")
	public String getelectorpermenantaddress() {
		return electorpermenantaddress;
	}
	@XmlElement(name="electorpermenantaddress")
	public void setelectorpermenantaddress(String electorpermenantaddress) {
		this.electorpermenantaddress = electorpermenantaddress;
	}
	@XmlElement(name="prmtAddElectorstate")
	public String getprmtAddElectorstate() {
		return prmtAddElectorstate;
	}
	@XmlElement(name="prmtAddElectorstate")
	public void setprmtAddElectorstate(String prmtAddElectorstate) {
		this.prmtAddElectorstate = prmtAddElectorstate;
	}
	@XmlElement(name="prmtAddElectordistrict")
	public String getprmtAddElectordistrict() {
		return prmtAddElectordistrict;
	}
	@XmlElement(name="prmtAddElectordistrict")
	public void setprmtAddElectordistrict(String prmtAddElectordistrict) {
		this.prmtAddElectordistrict = prmtAddElectordistrict;
	}
	@XmlElement(name="prmtAddElectorsubdistrict")
	public String getprmtAddElectorsubdistrict() {
		return prmtAddElectorsubdistrict;
	}
	@XmlElement(name="prmtAddElectorsubdistrict")
	public void setprmtAddElectorsubdistrict(String prmtAddElectorsubdistrict) {
		this.prmtAddElectorsubdistrict = prmtAddElectorsubdistrict;
	}
	@XmlElement(name="electorpincode")
	public double getelectorpincode() {
		return electorpincode;
	}
	@XmlElement(name="electorpincode")
	public void setelectorpincode(double electorpincode) {
		this.electorpincode = electorpincode;
	}
	@XmlElement(name="absentreason")
	public String getabsentreason() {
		return absentreason;
	}
	@XmlElement(name="absentreason")
	public void setabsentreason(String absentreason) {
		this.absentreason = absentreason;
	}
	@XmlElement(name="absentdescription")
	public String getabsentdescription() {
		return absentdescription;
	}
	@XmlElement(name="absentdescription")
	public void setabsentdescription(String absentdescription) {
		this.absentdescription = absentdescription;
	}
	@XmlElement(name="awaydate")
	public String getawaydate() {
		//return (Date) sdf.parse(awaydate);
		return awaydate;
	}
	@XmlElement(name="awaydate")
	public void setawaydate(String awaydate) {
		this.awaydate = awaydate;
	}
	@XmlElement(name="electorcurrentaddress")
	public String getelectorcurrentaddress() {
		return electorcurrentaddress;
	}
	@XmlElement(name="electorcurrentaddress")
	public void setelectorcurrentaddress(String electorcurrentaddress) {
		this.electorcurrentaddress = electorcurrentaddress;
	}
	@XmlElement(name="currAddElectorstate")
	public String getcurrAddElectorstate() {
		return currAddElectorstate;
	}
	@XmlElement(name="currAddElectorstate")
	public void setcurrAddElectorstate(String currAddElectorstate) {
		this.currAddElectorstate = currAddElectorstate;
	}
	@XmlElement(name="currAddElectordistrict")
	public String getcurrAddElectordistrict() {
		return currAddElectordistrict;
	}
	@XmlElement(name="currAddElectordistrict")
	public void setcurrAddElectordistrict(String currAddElectordistrict) {
		this.currAddElectordistrict = currAddElectordistrict;
	}
	@XmlElement(name="currAddElectorsubdistrict")
	public String getcurrAddElectorsubdistrict() {
		return currAddElectorsubdistrict;
	}
	@XmlElement(name="currAddElectorsubdistrict")
	public void setcurrAddElectorsubdistrict(String currAddElectorsubdistrict) {
		this.currAddElectorsubdistrict = currAddElectorsubdistrict;
	}
	@XmlElement(name="currelectorpincode")
	public double getcurrelectorpincode() {
		return currelectorpincode;
	}
	@XmlElement(name="currelectorpincode")
	public void setcurrelectorpincode(double currelectorpincode) {
		this.currelectorpincode = currelectorpincode;
	}
	@XmlElement(name="voterid")
	public String getvoterid() {
		return voterid;
	}
	@XmlElement(name="voterid")
	public void setvoterid(String voterid) {
		 this.voterid = voterid;
	}
}