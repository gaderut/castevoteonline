package com.ovs.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovs.VoterController;
import com.ovs.dao.DataRepository;
import com.ovs.model.Candidate;
import com.ovs.model.FingerPrint;
import com.ovs.model.Vote;
import com.ovs.model.Voter;
import com.ovs.fingerPrint.*;

@Service
public class DetailsHandling {

	@Autowired	
	private DataRepository dataRepository;
	
	InsertImage insertImage = new InsertImage();
	FR3 fr3 = new FR3();
	
	public boolean addVoter(Voter voter) throws SQLException, ParseException{
		System.out.println("Hello "+voter.getelectorfname()+" "+voter.getelectorlname());
		System.out.println(voter.getelectorfname()+"/"+
			voter.getelectormname()+"/"+
			voter.getelectorlname()+"/"+
			 voter.getelectorsex()+"/"+
			 voter.getelectorbdate()+"/"+
			  voter.getelectorstate()+"/"+
			  voter.getelectordistrict()+"/"+
			  voter.getelectorsubdistrict()+"/"+
			  voter.getelectorbirthplace()+"/"+
			  voter.getelectorrfname()+"/"+
			  voter.getelectorrmname()+"/"+
			  voter.getelectorrlname()+"/"+
			  voter.getelectorrelation()+"/"+
			voter.getelectoruid()+"/"+
			voter.getelectorphone()+"/"+
			 voter.getelectoremail()+"/"+
			 voter.getelectorpermenantaddress()+"/"+
			 voter.getprmtAddElectorstate()+"/"+
			  voter.getprmtAddElectordistrict()+"/"+
			 voter.getprmtAddElectorsubdistrict()+"/"+
			voter.getelectorpincode()+"/"+
			voter.getabsentreason()+"/"+
			 voter.getabsentdescription()+"/"+
			 voter.getawaydate()+"/"+
			voter.getelectorcurrentaddress()+"/"+
			 voter.getcurrAddElectorstate()+"/"+
			voter.getcurrAddElectordistrict()+"/"+
			voter.getcurrAddElectorsubdistrict()+"/"+
			voter.getcurrelectorpincode()+"/"+
			voter.getvoterid());
		voter.setvoterid(voter.getelectorfname()+"123");
		System.out.println(voter.getvoterid());
		return dataRepository.addVoter(voter);
	}
	
	public Voter editVoter(String voterId)  throws SQLException, ParseException{
		System.out.println("Detailshandling "+voterId);
		return dataRepository.editVoter(voterId);
	}
	
	public boolean addCandidate(Candidate candidate) throws SQLException, ParseException{
		candidate.setCandidateid(candidate.getEid()+"45");
		return dataRepository.addCandidate(candidate);
	}

	public Candidate editCandidate(String voterId)  throws SQLException, ParseException {
		return dataRepository.editCandidate(voterId);
	}

	public int getAadhar(String voterId) throws SQLException, ParseException {
		return dataRepository.getAadhar(voterId);
	}
	
	public boolean connectAadhar(String voterId, int uId) throws SQLException, ParseException {
		return dataRepository.connectAadhar(voterId, uId);
	}

	public Voter getConstituency(String voterId) throws SQLException, ParseException {
		return dataRepository.getConstituency(voterId);
	}
	
	public ArrayList<Candidate> getCandidateList(String voterId) throws SQLException, ParseException {
		System.out.println("in getCandidateList(DetailsHandling), voterId ="+voterId);
		return dataRepository.getCandidateList(voterId);
	}
	
	public boolean castVote(String voterId, String candidateId, String partyname, String electiondate, String electiontype) throws ParseException, SQLException {
		System.out.println("in cast vote DetailsHandling "+voterId+"/"+candidateId+"/"+partyname+"/"+electiondate+"/"+electiontype);
		return dataRepository.castVote(voterId, candidateId, partyname, electiondate, electiontype);
	}

	public boolean submitFeedback(String voterId, String feedback)  throws SQLException, ParseException{
		return dataRepository.submitFeedback(voterId, feedback);
	}

	public boolean addFingerPrint(FingerPrint fingerPrint)throws SQLException, ParseException {
		String voterId = fingerPrint.getVoterId();
		String fingerPrintPath = "C:\\Users\\hp hp\\Desktop\\New folder\\"+fingerPrint.getFingerPrintPath();
		return InsertImage.imageFunction(voterId, fingerPrintPath);
	}

	public boolean validateFingerPrint(FingerPrint fingerPrint) throws Exception  {
		String voterId = fingerPrint.getVoterId();
		String fingerPrintPath = "C:\\Users\\hp hp\\Desktop\\New folder\\"+fingerPrint.getFingerPrintPath();
		return fr3.validateFingerPrint(voterId, fingerPrintPath);
	}

		
}
