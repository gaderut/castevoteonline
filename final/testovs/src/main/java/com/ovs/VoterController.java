package com.ovs;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ovs.model.Candidate;
import com.ovs.model.FingerPrint;
import com.ovs.model.Vote;
import com.ovs.model.Voter;
import com.ovs.services.DetailsHandling;;

@Controller
@RequestMapping("/voter")
public class VoterController {
	@Autowired	
	private DetailsHandling detailsHandling;
	
	@RequestMapping(value="/addVoter",method = RequestMethod.POST)
	public @ResponseBody boolean addVoter(@RequestBody Voter voter) throws SQLException, ParseException{
	return detailsHandling.addVoter(voter);
	}
	
	@RequestMapping(value="/editVoter/{voterId}",method = RequestMethod.GET)
	public @ResponseBody Voter editVoter(@PathVariable("voterId") String voterId)  throws SQLException, ParseException{
		Voter voter = new Voter();
		voter = detailsHandling.editVoter(voterId);
		return voter;
	}
	
	@RequestMapping(value="/addCandidate",method = RequestMethod.POST)
	public @ResponseBody boolean addCandidate(@RequestBody Candidate candidate) throws SQLException, ParseException{
		return detailsHandling.addCandidate(candidate);
	}
	
	@RequestMapping(value="/editCandidate/{voterId}",method = RequestMethod.GET)
	public @ResponseBody Candidate editCandidate(@PathVariable("voterId") String voterId)  throws SQLException, ParseException{
		Candidate candidate = new Candidate(); 
		candidate = detailsHandling.editCandidate(voterId);
		return candidate;
	}
	
	@RequestMapping(value="/getAadhar/{voterId}",method = RequestMethod.POST)
	public @ResponseBody int getAadhar(@PathVariable("voterId") String voterId)  throws SQLException, ParseException{
		return detailsHandling.getAadhar(voterId);
	}
	
	@RequestMapping(value="/connectAadhar/{voterId}/{uId}",method = RequestMethod.POST)
	public @ResponseBody boolean connectAadhar(@PathVariable("voterId") String voterId, @PathVariable("uId") int uId)  throws SQLException, ParseException{
		return detailsHandling.connectAadhar(voterId, uId);
	}
	
	@RequestMapping(value="/getConstituency/{voterId}",method = RequestMethod.GET)
	public @ResponseBody Voter getConstituency(@PathVariable("voterId") String voterId)  throws SQLException, ParseException{
		Voter voter = new Voter();
		voter = detailsHandling.editVoter(voterId);
		return voter;
	}
	
	@RequestMapping(value="/getCandidateList/{voterId}",method = RequestMethod.GET)
	public @ResponseBody ArrayList<Candidate> getCandidateList(@PathVariable("voterId") String voterId)  throws SQLException, ParseException{
		System.out.println("in getCandidateList(Votercontroller), voterId ="+voterId);
		ArrayList<Candidate> candidatelist = new ArrayList<Candidate>();
		candidatelist = detailsHandling.getCandidateList(voterId);
		return candidatelist;
	}
	
	@RequestMapping(value="/castVote/{voterId}/{candidateId}/{partyname}/{electiondate}/{electiontype}",method = RequestMethod.POST)
	public @ResponseBody boolean castVote(@PathVariable("voterId") String voterId, @PathVariable("candidateId") String candidateId, @PathVariable("partyname") String partyname, @PathVariable("electiondate") String electiondate, @PathVariable("electiontype") String electiontype) throws SQLException, ParseException{
		System.out.println("in cast vote voterController "+voterId+"/"+candidateId+"/"+partyname+"/"+electiondate+"/"+electiontype);
		return detailsHandling.castVote(voterId, candidateId, partyname, electiondate, electiontype);
	}

	@RequestMapping(value="/submitFeedback/{voterId}/{feedback}",method = RequestMethod.POST)
	public @ResponseBody boolean submitFeedback(@PathVariable("voterId") String voterId, @PathVariable("feedback") String feedback)  throws SQLException, ParseException{
		return detailsHandling.submitFeedback(voterId, feedback);
	}
	
	@RequestMapping(value="/addFingerPrint",method = RequestMethod.POST)
	public @ResponseBody boolean addFingerPrint(@RequestBody FingerPrint fingerPrint)  throws SQLException, ParseException, UnsupportedEncodingException{
		System.out.println("fingerPrintPath in addFingerPrint"+fingerPrint.getVoterId()+"/"+fingerPrint.getFingerPrintPath());
		return detailsHandling.addFingerPrint(fingerPrint);
	}
	
	@RequestMapping(value="/valFingerPrint",method = RequestMethod.POST)
	public @ResponseBody boolean validateFingerPrint(@RequestBody FingerPrint fingerPrint)  throws Exception, SQLException, ParseException, UnsupportedEncodingException{
		System.out.println("fingerPrintPath in validateFingerPrint"+fingerPrint.getVoterId()+"/"+fingerPrint.getFingerPrintPath());
		return detailsHandling.validateFingerPrint(fingerPrint);
	}
}
