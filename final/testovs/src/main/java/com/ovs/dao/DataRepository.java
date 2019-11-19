package com.ovs.dao;

import java.sql.*;
import java.text.ParseException;

import oracle.jdbc.*;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ovs.model.Candidate;
import com.ovs.model.Vote;
import com.ovs.model.Voter;

import java.util.*;

@Repository
public class DataRepository {

	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	/**********************************************************************************************
	 * Function to fetch voter's mobile number from database
	 **********************************************************************************************/
	public long getMobileNum(String userId) throws SQLException {
		long mobNum = 0;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String insertSql = "{call LOGIN_PROC(?, ?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, userId);
			callableStatement.registerOutParameter(2, java.sql.Types.BIGINT);
			callableStatement.executeUpdate();
			mobNum = callableStatement.getLong(2);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		System.out.println("in dao, mobNum "+mobNum);
		return mobNum;
	}

	/**********************************************************************************************
	 * Function to add OTP into temporary database
	 **********************************************************************************************/
	public boolean insertOTP(String userId, String otp) throws SQLException {
		System.out.println("in insertOTP DR");
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;

		String insertSql = "{call STORE_OTP(?, ?, ?)}";

		try {  
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, userId);
			callableStatement.setString(2, otp);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			flag = callableStatement.getInt(3);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag == 0)
			return false;
		else
			return true;
	}
	
	/**********************************************************************************************
	 * Function to validate OTP from database
	 **********************************************************************************************/
	public boolean OtpValidation(String userId, String otp) throws SQLException {
		System.out.println("in otpValidation (app.js)");
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;

		String insertSql = "{call CHECK_OTP(?,?,?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);

			callableStatement.setString(1, userId);
			callableStatement.setString(2, otp);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			flag = callableStatement.getInt(3);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag == 0)
			return false;
		else
			return true;
	}

	/**********************************************************************************************
	 * Function to add voter into database
	 **********************************************************************************************/
	public boolean addVoter(Voter voter) throws SQLException, ParseException{
		
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag=0;

		String insertSql = "{call INSERT_VOTER(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";

		try {
//			dbConnection = getDBConnection();
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			
			callableStatement.setString(1, voter.getelectorfname());
			callableStatement.setString(2, voter.getelectormname());
			callableStatement.setString(3, voter.getelectorlname());
			callableStatement.setString(4, voter.getelectorsex());
			callableStatement.setString(5, voter.getelectorbdate());
			callableStatement.setString(6, voter.getelectorstate());
			callableStatement.setString(7, voter.getelectordistrict());
			callableStatement.setString(8, voter.getelectorsubdistrict());
			callableStatement.setString(9, voter.getelectorbirthplace());
			callableStatement.setString(10, voter.getelectorrfname());
			callableStatement.setString(11, voter.getelectorrmname());
			callableStatement.setString(12, voter.getelectorrlname());
			callableStatement.setString(13, voter.getelectorrelation());
			callableStatement.setDouble(14, voter.getelectoruid());
			callableStatement.setDouble(15, voter.getelectorphone());
			callableStatement.setString(16, voter.getelectoremail());
			callableStatement.setString(17, voter.getelectorpermenantaddress());
			callableStatement.setString(18, voter.getprmtAddElectorstate());
			callableStatement.setString(19, voter.getprmtAddElectordistrict());
			callableStatement.setString(20, voter.getprmtAddElectorsubdistrict());
			callableStatement.setDouble(21, voter.getelectorpincode());
			callableStatement.setString(22, voter.getabsentreason());
			callableStatement.setString(23, voter.getabsentdescription());
			callableStatement.setString(24, voter.getawaydate());
			callableStatement.setString(25, voter.getelectorcurrentaddress());
			callableStatement.setString(26, voter.getcurrAddElectorstate());
			callableStatement.setString(27, voter.getcurrAddElectordistrict());
			callableStatement.setString(28, voter.getcurrAddElectorsubdistrict());
			callableStatement.setDouble(29, voter.getcurrelectorpincode());
			callableStatement.setString(30, voter.getvoterid());
			
			callableStatement.registerOutParameter(31, java.sql.Types.INTEGER);

			callableStatement.executeUpdate();
			flag = callableStatement.getInt(31);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag==1)
			return true;
		else
			return false;
	}
	
	/**********************************************************************************************
	 * Function to fetch voter details from database
	 **********************************************************************************************/
	public Voter editVoter(String voterId) throws SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;
		System.out.println("in editVoter(DataRepository), voterId123 "+voterId);
		String insertSql = "BEGIN get_voter_details(?,?); END;";
		Voter voter = new Voter();
		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			System.out.println(insertSql);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println(insertSql);
			callableStatement.execute();
			ResultSet rs1 = ((OracleCallableStatement) callableStatement).getCursor(2);
			
			while (rs1.next()) {
//				System.out.println("finally u did it "+rs1.getString("ELECTORFNAME"));
				  voter.setelectorfname(rs1.getString(1));
				  System.out.println("in assign, "+voter.getelectorfname());
//				  System.out.println("finally u did it "+rs1.getString("ELECTORLNAME"));
				
				  voter.setelectormname(rs1.getString(2));
				  voter.setelectorlname(rs1.getString(3));  
//				  System.out.println("in assign, "+voter.getelectorlname());
				  voter.setelectorsex(rs1.getString(4));
				  voter.setelectorbdate(rs1.getString(5));
				  voter.setelectorstate(rs1.getString(6));
				  voter.setelectordistrict(rs1.getString(7));
				  voter.setelectorsubdistrict(rs1.getString(8));
				  voter.setelectorbirthplace(rs1.getString(9));
				  voter.setelectorrfname(rs1.getString(10));
				  voter.setelectorrmname(rs1.getString(11));
				  voter.setelectorrlname(rs1.getString(12));
				  voter.setelectorrelation(rs1.getString(13));
				  voter.setelectoruid(rs1.getDouble(14));
				  voter.setelectorphone(rs1.getDouble(15));
				  voter.setelectoremail(rs1.getString(16));
				  voter.setelectorpermenantaddress(rs1.getString(17));
				  voter.setprmtAddElectorstate(rs1.getString(18));
				  voter.setprmtAddElectordistrict(rs1.getString(19));
				  voter.setprmtAddElectorsubdistrict(rs1.getString(20));
				  voter.setelectorpincode(rs1.getDouble(21));
				  voter.setabsentreason(rs1.getString(22));
				  voter.setabsentdescription(rs1.getString(23));			
				  voter.setawaydate(rs1.getString(24));
				  voter.setelectorcurrentaddress(rs1.getString(25));
				  voter.setcurrAddElectorstate(rs1.getString(26));
				  voter.setcurrAddElectordistrict(rs1.getString(27));
				  voter.setcurrAddElectorsubdistrict(rs1.getString(28));
				  voter.setcurrelectorpincode(rs1.getDouble(29));
	          }
	          rs1.close();

	          /* process second result set */
//	          if (callableStatement.getMoreResults()) {
//	               ResultSet rs2 = callableStatement.getResultSet();
//	               while (rs2.next()) {
//	                    System.out.println(rs2.getInt(1) + " " + rs2.getString(2) + " "
//	                              + rs2.getString(3));
//	               }
//	               rs2.close();
//	          }
	          
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
//		if(flag == 0)
//			return null;
//		else
			return voter;
	}

	/**********************************************************************************************
	 * Function to add candidate into database
	 **********************************************************************************************/
	public boolean addCandidate(Candidate candidate) throws ParseException, SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;

		String insertSql = "{call INSERT_CANDIDATE(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);

			callableStatement.setString(1, candidate.getEid());
			callableStatement.setString(2, candidate.getFname());
			callableStatement.setString(3, candidate.getMname());
			callableStatement.setString(4, candidate.getLname());
			callableStatement.setString(5, candidate.getSex());
			callableStatement.setString(6, candidate.getBdate());
			callableStatement.setDouble(7, candidate.getUid());
			callableStatement.setDouble(8, candidate.getPhone());
			callableStatement.setString(9, candidate.getEmail());
			callableStatement.setString(10, candidate.getPartyname());
			callableStatement.setString(11, candidate.getElectiondate());
			callableStatement.setString(12, candidate.getConteststate());
			callableStatement.setString(13, candidate.getContestdistrict());
			callableStatement.setString(14, candidate.getContestsubdistrict());
			callableStatement.setString(15, candidate.getCandidateid());
			callableStatement.setString(16, candidate.getElectiontype());
			callableStatement.registerOutParameter(17, java.sql.Types.INTEGER);

			callableStatement.executeUpdate();
			flag = callableStatement.getInt(17);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag == 0)
			return false;
		else
			return true;
	}

	/**********************************************************************************************
	 * Function to fetch candidate details from database
	 **********************************************************************************************/
	public Candidate editCandidate(String voterId) throws SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		System.out.println("in editCandidate(DataRepository), voterId "+voterId);
		String insertSql = "BEGIN get_candidate_details(?,?); END;";
		Candidate candidate = new Candidate();
		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet rs1 = ((OracleCallableStatement) callableStatement).getCursor(2);
			
			while (rs1.next()) {
				  candidate.setEid(rs1.getString(1));
				  candidate.setFname(rs1.getString(2));
				  candidate.setMname(rs1.getString(3));
				  candidate.setLname(rs1.getString(4));
				  candidate.setSex(rs1.getString(5));
				  candidate.setBdate(rs1.getString(6));
				  candidate.setUid(rs1.getDouble(7));
				  candidate.setPhone(rs1.getDouble(8));
				  candidate.setEmail(rs1.getString(9));
				  candidate.setPartyname(rs1.getString(10));
				  candidate.setElectiondate(rs1.getString(11));
				  candidate.setConteststate(rs1.getString(12));
				  candidate.setContestdistrict(rs1.getString(13));
				  candidate.setContestsubdistrict(rs1.getString(14));
				  candidate.setCandidateid(rs1.getString(15));
				  candidate.setElectiontype(rs1.getString(16));
				  }
	          rs1.close();
	          
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
			return candidate;
	}

	/**********************************************************************************************
	 * Function to fetch AADHAR number of voter from the database
	 **********************************************************************************************/
	public int getAadhar(String voterId) throws SQLException {
		System.out.println("in getAadhar DR");
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int uId = 0;

		String insertSql = "{call getAadhar(?, ?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			uId = callableStatement.getInt(2);
			System.out.println("the uid in getAAdhar is"+uId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(uId == 0)
			return 0;
		else
			return uId;
	}
	
	/**********************************************************************************************
	 * Function to add AADHAR number against voter details in the database
	 **********************************************************************************************/
	public boolean connectAadhar(String voterId, int uId) throws SQLException {
		System.out.println("in connectAadhar DR");
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;

		String insertSql = "{call connectAadhar(?, ?, ?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			callableStatement.setInt(2, uId);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			flag = callableStatement.getInt(3);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag == 0)
			return false;
		else
			return true;
	}

	/**********************************************************************************************
	 * Function to get constituency of voter
	 * @throws SQLException 
	 **********************************************************************************************/
	public Voter getConstituency(String voterId) throws SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;
		System.out.println("in getConstituency(DataRepository), voterId123 "+voterId);
		String insertSql = "BEGIN get_voter_details(?,?); END;";
		Voter voter = new Voter();
		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			System.out.println(insertSql);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println(insertSql);
			callableStatement.execute();
			ResultSet rs1 = ((OracleCallableStatement) callableStatement).getCursor(2);
			
			while (rs1.next()) {
				  voter.setprmtAddElectorstate(rs1.getString(1));
				  voter.setprmtAddElectordistrict(rs1.getString(2));
				  voter.setprmtAddElectorsubdistrict(rs1.getString(3));
	          }
	          rs1.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
			return voter;
	}
	
	/**********************************************************************************************
	 * Function to fetch candidate list particular to voter's constituency from database
	 * @throws SQLException 
	 **********************************************************************************************/
	public ArrayList<Candidate> getCandidateList(String voterId) throws SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		System.out.println("test 2 in getCandidateList(DataRepository), voterId "+voterId);
		String insertSql = "BEGIN FETCH_CANDIDATES(?,?); END;";
		ArrayList<Candidate> candidatelist = new ArrayList<Candidate>();
		
		try {
			System.out.println("step 1 voterid"+voterId);
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet rs1 = ((OracleCallableStatement) callableStatement).getCursor(2);
			System.out.println("step 2");
			int i=1;
			while (rs1.next()) {
				System.out.println("i"+i);
				Candidate candidate = new Candidate();
				  candidate.setEid(rs1.getString(1));
				  candidate.setFname(rs1.getString(2));
				  candidate.setMname(rs1.getString(3));
				  candidate.setLname(rs1.getString(4));
				  candidate.setSex(rs1.getString(5));
				  candidate.setBdate(rs1.getString(6));
				  candidate.setUid(rs1.getDouble(7));
				  candidate.setPhone(rs1.getDouble(8));
				  candidate.setEmail(rs1.getString(9));
				  candidate.setPartyname(rs1.getString(10));
				  candidate.setElectiondate(rs1.getString(11));
				  candidate.setConteststate(rs1.getString(12));
				  candidate.setContestdistrict(rs1.getString(13));
				  candidate.setContestsubdistrict(rs1.getString(14));
				  candidate.setCandidateid(rs1.getString(15));
				  candidate.setElectiontype(rs1.getString(16));
				  candidatelist.add(candidate);
				  i++;
				  }
	          rs1.close();
	          System.out.println("step 3");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
			return candidatelist;
	}
	
	/**********************************************************************************************
	 * Function to submit vote
	 * @param electiontype 
	 * @param electiondate 
	 * @param partyname 
	 **********************************************************************************************/
	public boolean castVote(String voterId, String candidateId, String partyname, String electiondate, String electiontype) throws SQLException, ParseException{
		
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag=0;
		System.out.println("in cast vote DR "+voterId+"/"+candidateId+"/"+partyname+"/"+electiondate+"/"+electiontype);
		String insertSql = "{call CAST_VOTE(?,?,?,?,?, ?)}";

		try {
//			dbConnection = getDBConnection();
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			
			callableStatement.setString(1, voterId);
			callableStatement.setString(2, candidateId);
			callableStatement.setString(3, partyname);
			callableStatement.setString(4, electiondate);
			callableStatement.setString(5, electiontype);
			callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);

			callableStatement.executeUpdate();
			flag = callableStatement.getInt(6);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		System.out.println("in castVote(DR), flag "+flag);
		if(flag==1)
			return false;
		else
			return true;
	}
	
	/**********************************************************************************************
	 * Function to add feedback into database
	 **********************************************************************************************/
	public boolean submitFeedback(String voterId, String feedback) throws SQLException {
		System.out.println("in submitFeedback DR");
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		int flag = 0;

		String insertSql = "{call submit_feedback(?, ?, ?)}";

		try {
			dbConnection = dataSource.getConnection();
			callableStatement = dbConnection.prepareCall(insertSql);
			callableStatement.setString(1, voterId);
			callableStatement.setString(2, feedback);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			flag = callableStatement.getInt(3);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if(flag == 0)
			return false;
		else
			return true;
	}
}
