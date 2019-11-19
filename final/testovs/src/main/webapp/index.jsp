<!DOCTYPE HTML>
<html ng-app="cyberWarApp">
	<head>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/dropdowns-enhancement.js"></script>
		<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="js/angular.min.js"></script>
		<!-- <script type="text/javascript" src="js/app.js"></script> -->
		<script type="text/javascript" src="js/app1.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<script src="json/ConstiTuencies.json"></script>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/bootstrap-datepicker.css">
		<link rel="stylesheet" href="css/dropdowns-enhancement.css">
				
		<title>CyberVoting</title>
	</head>
	
	<body id="body" class="disabled-scrollbar">
	
<!----------------------------------------------------------------------------------------------------
	Navigation Bar
  ---------------------------------------------------------------------------------------------------->	
		<nav ng-controller="navBarCtrl" class="navbar navbar-inverse navbar-fixed-top" id="navbar1">
			<div class="container">
				<div class="navbar-header row">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#optionbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="" class="navbar-brand">CyberVoting</a>
				</div>
				<div class="collapse navbar-collapse" id="optionbar">
					<a id="loginButton" href="" class="btn btn-info navbar-btn navbar-right" data-toggle="modal" data-target="#loginmodal">Login</a>
					<ul class="nav navbar-nav dropdown">
						<!-- <li><a href="#voter" >Voter</a></li> -->
						<li data-target="#reg_form_modal" data-toggle="modal"><a>Voter Registration</a></li>
						<!-- <li><a href="#candidate" id="dropdownMenu1" class="dropdown dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Candidate<span class="caret"></span></a> -->
							<!-- <ul class="dropdown-menu bullet pull-center" id="candidatedropdownid" aria-labelledby="dropdownMenu1"> -->
						    <li data-target="#cand_reg_form_modal" data-toggle="modal"><a>Candidate Registration</a></li>
						    <!-- <li data-target="#cand_reg_form_modal" data-toggle="modal"><a>View Details</a></li> -->
						  <!-- </ul> -->
						<!-- </li> -->
						<li><a href="#elections" id="dropdownMenu2" class="dropdown dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Elections<span class="caret"></span></a>
							<ul class="dropdown-menu bullet pull-center" id="electiondropdownid" aria-labelledby="dropdownMenu2">
						    <li><a target="_blank" href="assets/FutureElections/eci.nic.in_eci_main1_ByeElec2015_Maharastra1.pdf">Maharashtra</a></li>
						    <li><a target="_blank" href="assets/FutureElections/eci.nic.in_eci_main1_ByeElec2015_Punjab.pdf">Punjab</a></li>
						    <li><a target="_blank" href="assets/FutureElections/eci.nic.in_eci_main1_ByeElec2015_Uttar Pradesh.pdf">Uttar Pradesh</a></li>
						    <li><a target="_blank" href="assets/FutureElections/eci.nic.in_eci_main1_ByeElec2015_Uttrakhand.pdf">Uttarakhand</a></li>
						  	</ul>
						<li><a href="#FAQ" id="dropdownMenu3" class="dropdown dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">FAQs<span class="caret"></span></a>
							<ul class="dropdown-menu bullet pull-center" id="FAQdropdownid" aria-labelledby="dropdownMenu3">
						    <li><a target="_blank" href="assets/FAQ/faq_contesting_for_elections.pdf">Contesting for Elections</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_counting_and_declaration_of_result.pdf">Results</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_delimitation_of_constituencies.pdf">Delimination of Counstituencies</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_election_machinery.pdf">Election Machinery</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_evm.pdf">EVM</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_general_elector.pdf">General Elector</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_NRI_voters.pdf">NRI voters</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_parliament.pdf">Parliament</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_registeration_of_political_parties.pdf">Party Registration</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_ROs_DEOs.pdf">ROs nad DEOs</a></li>
						    <li><a target="_blank" href="assets/FAQ/faq_service_voter.pdf">Service Voters</a></li>
						  	</ul>
						<!-- <li><a href="#results" >Results</a></li> -->
						<li><a target="_blank" href="html/gallery.html" >Gallery</a></li>
						<li><a href="#rti" id="dropdownMenu6" class="dropdown dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">RTI<span class="caret"></span></a>
							<ul class="dropdown-menu bullet pull-center" id="RTIdropdownid" aria-labelledby="dropdownMenu6">
						    <li><a target="_blank" href="assets/RTI/application_fee.pdf">Application Fees</a></li>
						    <li><a target="_blank" href="assets/RTI/CPIO.pdf">CPIO</a></li>
						   	<li><a target="_blank" href="assets/RTI/monthly_return_aug2011.pdf">Monthly Return Aug 2011</a></li>
						   	<li><a target="_blank" href="assets/RTI/monthly_return_2013-14.pdf">Monthly Return 2013-14</a></li>
						  	<li><a target="_blank" href="assets/RTI/monthly_return_2014-15.pdf">Monthly Return 2013-14</a></li>
						  	<li><a target="_blank" href="assets/RTI/proactive_disclosure.pdf">Proactive Disclosure</a></li>
						  	</ul>
						</li>
						<li><a href="#givefeedbackid">Feedback</a></li>
						<li><a href="#contactus" >Contact Us</a></li>
					</ul>
				</div>
			</div>
		</nav>

<!----------------------------------------------------------------------------------------------------
	Carousel
  ---------------------------------------------------------------------------------------------------->

<section id="home">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
		  </ol>
		 
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner">
		    
		    <div class="item active">
		      <img src="images/slider10.jpg" alt="...">
		      <div class="carousel-caption">
		          <h3>CyberVoting</h3>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/slider11.jpg" alt="...">
		      <div class="carousel-caption">
		          <h3>CyberVoting</h3>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/slider12.jpg" alt="...">
		      <div class="carousel-caption">
		          <h3>CyberVoting</h3>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/slider13.jpg" alt="...">
		      <div class="carousel-caption">
		          <h3>CyberVoting</h3>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/slider14.jpg" alt="...">
		      <div class="carousel-caption">
		          <h3>CyberVoting</h3>
		      </div>
		    </div>
		  </div>
		</section>
		

		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		  </a>
		</div> <!-- Carousel -->

<!----------------------------------------------------------------------------------------------------
	Voter Options Panel
  ---------------------------------------------------------------------------------------------------->

		<section  ng-controller="voterOptionsCtrl" class="section " id="voter">
			<div class="container main text-center">
				<div class="page-header" >
					<h2>Voter <small> Access the below functionality</small></h2>
				</div>
				<div>	
					<div class="row">
						<div class="col-lg-4 container" data-target="#reg_form_modal" data-toggle="modal">
							<h4>Registration <small> Register for online voting</small></h4>
							<img src="images/a1.png">
						</div>
						<div class="col-lg-4 container" data-target="#reg_form_modal" data-toggle="modal">
							<h4>View details <small> View and edit existing details</small></h4>
							<img src="images/a2.png" ng-click="editVoter()">
						</div>
						<div class="col-lg-4 container" data-target="#adhar_linking" data-toggle="modal">
							<h4>Aadhar Linking <small> Connect to your Aadhaar Card</small></h4>
							<img src="images/a3.png" ng-click="getAadhar()">
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-lg-4 container" data-target="#constituencyModal" data-toggle="modal">
							<h4>Search Constituency <small>Check your constituency</small></h4>
							<img src="images/a4.png" ng-click="getConstituency()">
						</div>
						<div class="col-lg-4">
							<h4>Search Candidates <small>Representing constituency </small></h4>
							<img src="images/a5.png" ng-click="callVotingHtml('viewList')">
						</div>
						<div class="col-lg-4">
							<h4>Cast Vote <small> Vote for a candidate</small></h4>
							<!-- <a href="html/voting.html?voterId="+><img src="images/a6.png" ng-click="castVote()"></a> -->
							<img src="images/a6.png" ng-click="callVotingHtml('vote')">
						</div>
					</div>
					<hr>
				</div>
			</div>
		</section>

<!----------------------------------------------------------------------------------------------------
	Feedback Panel
  ---------------------------------------------------------------------------------------------------->
  
		<!-- <section class="section " id="feedback">
			<div class="container main text-center">
				<div class="page-header" >
					<h2>Feedback.<small>Check here some awesome feedback.</small></h2>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<blockquote>
							<p>One of the greatest challenges any recognition program faces is maintaining momentum after the newness of the program wears off. Use these easy and low cost ideas to keep your employee recognition program fresh and exciting!
							</p>
							<footer>Tejas Saitwal</footer>
						</blockquote>
					</div>
					<div class="col-lg-4">
						<blockquote>
							<p>A theme is part of a successful Employee Appreciation Day. Use one of our ten theme ideas for Employee Appreciation Day for a fun day with your team!
							</p>
							<footer>Pranay Jaipuriya</footer>
						</blockquote>
					</div>
					<div class="col-lg-4">
						<blockquote>
							<p>LOL
							</p>
							<footer>Surbhi Gupta
							</footer>
						</blockquote>
					</div>
					<div class="col-lg-4">
						<blockquote>
							<p>These 25 Boss's Day gift ideas will get you ready for Boss's Day on October 16!
							</p>
							<footer>Rutuja Gadekar
							</footer>
						</blockquote>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<div class="btn-group">
							<a href="#givefeedbackid" class="btn btn-lg btn-info">Give One</a>
						</div>
					</div>
				</div>
			</div>
		</section> -->

<!----------------------------------------------------------------------------------------------------
	Feedback Form
  ---------------------------------------------------------------------------------------------------->
  
		<section ng-controller="feedbackFormCtrl" class="section" id="givefeedbackid">
			<div class="container text-center main" >
				<div class="well">
					<h3>Feedback</h3>
					<br>
					<p>Enter your auspicious feedback</p>
					<form action="post" role="form">
						
						<div class="form-group row">
							<div class="col-lg-4"></div>
							<div class="col-lg-4">
								<!-- <label for="feedback">Your Feedback</label> -->
								<textarea class="form-control" ng-model="feedback" name="feedback" placeholder="Enter your feedback here." id="feedbackid"/></textarea>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-4"></div>
							<div class="col-lg-4">
								<div class="btn-group">
									<a href="" ng-click="submitFeedback()" class="btn btn-lg btn-info">Submit</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</section>
		
<!----------------------------------------------------------------------------------------------------
	Login Modal
 ---------------------------------------------------------------------------------------------------->	
		
		 <div ng-controller="loginCtrl" class="modal fade loginModal" id="loginmodal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" style="color:red" class="close" data-dismiss="modal">&times;</button>
		          <h4 align="center" class="modal-title">Sign in to continue to cybervoting</h4>
		        </div>
		        <div class="modal-body">
		        	<div class="row" id="div_loginvoterid">
		        		<div class="col-lg-2"></div>
		        		<div class="col-lg-8 input-group">
		        			<input type="text" class="form-control" placeholder="Enter a valid voter's ID." id="id_loginvoterid" name="nm_loginvoterid" ng-model="nm_loginvoterid" onkeydown = "if (event.keyCode == 13){document.getElementById('btn_loginpassword').click()}"/>
		        			<span class="input-group-addon" ng-click="sendOTP()"><span class="glyphicon glyphicon-search" id="btn_loginpassword"></span></span>
		        		</div>
		        	</div>
		        	
		         	<div class="row hidden" id="div_loginpassword">
		        		<hr>
		        		<div class="col-lg-2"></div>
		        		<div class="col-lg-8 input-group">
		        			<input type="password" class="form-control" placeholder="Enter One Time Password." id="id_loginpassword" name="nm_loginpassword" ng-model="nm_loginpassword"/>
		        			<span class="input-group-addon" ng-click="validate()"><span class="glyphicon glyphicon-arrow-right" id="btn_loginpassword"></span></span>
		        		</div>
		        	</div>
		        </div>
		        <div class="modal-footer">
		        	<a href="#"></a>
		          <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button-->
		         <!--  <button type="button" ng-click="validate()" class="btn btn-success" data-dismiss="modal">Next</button-->
		        </div>
		      </div>
		    </div>
		  </div>
  		
<!----------------------------------------------------------------------------------------------------
	Voter Registration Modal
  ---------------------------------------------------------------------------------------------------->
  		
		 <div ng-controller="voterRegCtrl" class="modal fade" id="reg_form_modal" role="dialog">
			<div class="modal-dialog">
		      <!-- Modal content-->
		    	  <div class="modal-content">
		        		<div class="modal-header">
		          			<button type="button" style="color:red" class="close" data-dismiss="modal">&times;</button>
		          			<h4 class="modal-title">Registration to continue to cybervoting</h4>
		        		</div>
		        		<div class="modal-body">
							<form class="form" id="form1">
								<div class="">
									<div class="well">
										<div class = "row">
											<div class="col-lg-12">
												<div class="input-group">
													<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" name="electorfname" ng-model="e.electorfname" id="electorfnameid" class="form-control nodigits" placeholder="Elector's First Name." required/>
													
												</div>
												<br>
												<div class="alert hidden alert-danger" id="errorfname">
			 										<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
												</div>
											</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
												<div class="input-group">
												<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" class="form-control" name="electormname" ng-model="e.electormname" id="electormnameid" placeholder="Elector's Middle Name." required/>
												</div>
												<br>	
													<div class="alert hidden alert-danger" id="errormname">
					 									<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
												<div class="input-group">
												<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" class="form-control" name="electorlname" ng-model="e.electorlname" required id="electorlnameid" placeholder="Elector's Last Name."/>
													
												</div>
													<br>
													<div class="alert hidden alert-danger" id="errorlname">
			 											<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
													</div>
												</div>
												<br>
											</div>
									<div class = "row">
										<div class="col-lg-2"><label><font color = "gray" size="3%">Gender:</font></label></div>
										<div class="col-lg-10">
											<div class ="row">
												<div class="col-lg-2"><label>Male:</label></div><div class="col-lg-2"><input required type="radio" class="radio" name="electorsex" ng-model="e.electorsex" value="M" id="electorsexmale"></div>
												<div class="col-lg-2"><label>Female:</label></div><div class="col-lg-2"><input required type="radio" class = "radio" name="electorsex" ng-model="e.electorsex" value="F" id="electorsexfemale"></div>
												<div class="col-lg-2"><label>Other:</label></div><div class="col-lg-2"><input required type="radio" class="radio" name="electorsex" ng-model="e.electorsex" value="O" id="electorsexother"></div>
											</div>
										</div>
									</div>
								<br>
								<div class = "row ">
									<div class="col-lg-12">
										<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-calendar"></div></span>
											<input type="date" class="form-control date datepicker1"  name="electorbdate" ng-model="e.electorbdate" id="electorbdateid" placeholder="Elector's  Birth Date." required/>
											
										</div>
										</div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-12"><div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<input type="text" class="form-control"  name="electorbirthplace" ng-model="e.electorbirthplace" id="electorbirthplaceid" placeholder="Elector's Birth Place." required/>
										
										<div class="alert hidden alert-danger" id="errorelectorbirthplace">
											<br>
			 								<strong>Error!</strong> Only uppercase,lowercase letters and numbers are allowed.
										</div>
										</div>
									</div>
								</div>
								<br>
								<div class = "row">		
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control"  name="electorstate" onchange="setDistrict();" ng-model="e.electorstate" id="electorstateid" required> -->
										<select class="form-control"  name="electorstate" ng-model="e.electorstate" id="electorstateid" required>
											<option value="">Elector's Birth State.</option>
										</select>
									</div>
								</div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control"  name="electordistrict" ng-model="e.electordistrict" onchange="setSubDistrict();" id="electordistrictid"  required> -->
										<select class="form-control"  name="electordistrict" ng-model="e.electordistrict" id="electordistrictid"  required>
											<option value="">Elector's Birth District.</option>
										</select>
									</div></div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control"  name="electorsubdistrict" ng-model="e.electorsubdistrict" id="electorsubdistrictid"  required>
											<option value="">Elector's Birth Town/Village.</option>
										</select></div>
									</div>
								</div>
								<br>
								<div class = "row">
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-link"></div></span>
										<input type="text" class="form-control"  name="electorrfname" ng-model="e.electorrfname" id="electorrfnameid" placeholder="Father's/Mother's/Husband's First Name" required/>
									</div>
										<div class="alert hidden alert-danger" id="errorrfname">
			 								<br><strong>Error!</strong> Only uppercase and lowercase letters are allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
								
									<div class="col-lg-12">
										<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-link"></div></span>
										<input type="text" class="form-control"  name="electorrmname" ng-model="e.electorrmname" id="electorrmnameid" placeholder="Father's/Mother's/Husband's Middle Name" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorrmname">
			 							<br>	<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
								
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-link"></div></span>
										<input type="text" class="form-control"  name="electorrlname" ng-model="e.electorrlname" id="electorrlnameid" placeholder="Father's/Mother's/Husband's Last Name" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorrlname">
			 								<br><strong>Error!</strong> Only uppercase and lowercase letters are allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
								
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-tag"></div></span>
										<select class="form-control" name="electorrelation" ng-model="e.electorrelation" id="electorrelationid" required>
											<option value="">Relation for above</option>
											<option value="father">Father</option>
											<option value="mother">Mother</option>
											<option value="husband">Husband</option>
											<option value="wife">Wife</option>
										</select>
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-credit-card"></div></span>
										<input type="number" class="form-control"  name="electoruid" ng-model="e.electoruid" id="electoruidid" placeholder="AADHAR Number" required/>
										</div>
										<div class="alert hidden alert-danger" id="erroraadhar">
			 								<br><strong>Error!</strong> Only ten digit number allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-phone-alt"></div></span>
										<input type="number" class="form-control" name="electorphone" ng-model="e.electorphone" id="electorphoneid" placeholder="Phone" required/>
										
									</div>
										
										<div class="alert hidden alert-danger" id="errorphone">
			 								<br><strong>Error!</strong> Only ten digit number allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-envelope"></div></span>
										<input type="text" class="form-control"  name="electoremail" ng-model="e.electoremail" id="electoremailid" placeholder="Email ID" required/>
										
									</div>
										
										<div class="alert hidden alert-danger" id="erroremail">
			 								<br><strong>Error!</strong> Enter a valid email ID. (Ex.mailme@mail.domainname)
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<input type="text" class="form-control" name="electorpermenantaddress" ng-model="e.electorpermenantaddress" id="electorpermenantaddressid" placeholder="Permanent Address" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorspmtadd">
			 								<br><strong>Error!</strong> Only uppercase,lowercase letters and numbers are allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control" name="prmtAddElectorstate" ng-model="e.prmtAddElectorstate" onchange="setpmtDistrict();" id="prmtAddElectorstateid" required> -->
										<select class="form-control" name="prmtAddElectorstate" ng-model="e.prmtAddElectorstate" id="prmtAddElectorstateid" required>
											<option value="">State</option>
										</select>
									</div></div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control" name="prmtAddElectordistrict" ng-model="e.prmtAddElectordistrict" onchange="setpmtSubDistrict();" id="prmtAddElectordistrictid" required> -->
										<select class="form-control" name="prmtAddElectordistrict" ng-model="e.prmtAddElectordistrict" id="prmtAddElectordistrictid" required>
											<option value="">District</option>
										</select>
									</div></div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control" name="prmtAddElectorsubdistrict" ng-model="e.prmtAddElectorsubdistrict" id="prmtAddElectorsubdistrictid" required>
											<option value="">Town/Village</option>
										</select>
										</div></div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-barcode"></div></span>
										<input type="number"  class="form-control" name="electorpincode" ng-model="e.electorpincode" id="electorpincodeid" placeholder="Pincode" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorpincode">
			 								<br><strong>Error!</strong> Enter six digit correct pincode.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
										<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-question-sign"></div></span>
										<input type="text"  class="form-control" name="absentreason" ng-model="e.absentreason" id="absentreasonid" placeholder="Reason of being absent from the place of ordinary residence" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorabsentreason">
			 								<br><strong>Error!</strong> Length must be between minimum 10 to maximum 30 characters.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-align-justify"></div></span>
										<input type="text"  class="form-control" name="absentdescription" ng-model="e.absentdescription" id="absentdescriptionid" placeholder="Description for above" required/>
									</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-calendar"></div></span>
										<input type="date"  class="form-control date datepicker1" name="awaydate" ng-model="e.awaydate" id="awaydateid" placeholder="Date from which you are away from ordinary residence" required/>
										
									</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<input type="text"  class="form-control" name="electorcurrentaddress" ng-model="e.electorcurrentaddress" id="electorcurrentaddressid" placeholder="Current Address" required/>
											</div>
											<div class="alert hidden alert-danger" id="errorcurrentadd">
				 								<br><strong>Error!</strong> Only uppercase,lowercase letters and numbers are allowed.
											</div>
									</div>
									
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control"  name="currAddElectorstate" ng-model="e.currAddElectorstate" onchange="setcurrDistrict();" id="currAddElectorstateid" required> -->
										<select class="form-control"  name="currAddElectorstate" ng-model="e.currAddElectorstate" id="currAddElectorstateid" required>
											<option value="">State</option>
										</select>
									</div></div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<!-- <select class="form-control"  name="currAddElectordistrict" ng-model="e.currAddElectordistrict" onchange="setcurrSubDistrict();" id="currAddElectordistrictid" required> -->
										<select class="form-control"  name="currAddElectordistrict" ng-model="e.currAddElectordistrict" id="currAddElectordistrictid" required>
											<option value="">District</option>
										</select></div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control" name="currAddElectorsubdistrict" ng-model="e.currAddElectorsubdistrict" id="currAddElectorsubdistrictid" required>
											<option value="">Town/Village</option>
										</select></div>
										</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-barcode"></div></span>
										<input type="number" class="form-control" name="currelectorpincode" ng-model="e.currelectorpincode" id="currelectorpincodeid" placeholder="Pincode" required/>
										
										<div class="alert hidden alert-danger" id="errorcurrpincode">
			 								<br><strong>Error!</strong> Enter six digit correct pincode.
										</div></div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-8">
									<div class="input-group">
									<!-- <div>Please select Finger Print image in '.png' format only</div> -->
									<span class="input-group-addon"><div class="glyphicon glyphicon-barcode"></div></span>
										<input type="file" accept="image/png" class="form-control" name="fingerPrint" ng-model="fingerPrint" id="fingerPrintid" placeholder="fingerPrint path" required/>
										</div>
										
									</div>
									<div class="col-lg-4">
										<button id="btnAddFingerPrint" type="button" ng-click="addFingerPrint()" class="btn btn-md btn-default">Add Finger Print</button>
									</div>
								</div>
								<br>
								<div class = "row">
									<div class="col-lg-5"></div>
									<div class="col-lg-3">
										<div class="btn-group ">					
											<button id="btnAddUser" type="button" ng-click="addVoter()" class="btn btn-md btn-success"> Save</button>
										</div>
									</div>
								</div>
								
							</div>
						</div>
					</form>
				</div>
				</div>
		</div>
		</div>
		
<!----------------------------------------------------------------------------------------------------
	Candidate registration Modal
  ---------------------------------------------------------------------------------------------------->
  		
		<div ng-controller="candidateRegCtrl" class="modal fade" id="cand_reg_form_modal" role="dialog">
			<div class="modal-dialog">
		      <!-- Modal content-->
		    	  <div class="modal-content">
		        		<div class="modal-header">
		          			<button type="button" style="color:red" class="close" data-dismiss="modal">&times;</button>
		          			<h4 class="modal-title">Candidate Registration Form</h4>
		        		</div>
		        		<div class="modal-body">
							<form class="form" id="form2">
								<div class="">
									<div class="well">
										<!-- <br>
										<div align="center">
											<img id="profilephotoid" src="#" alt="Profile Photo"/>
											<br><br>
											<input type='file' onchange="upload(this)"/>
										</div> -->
										<br>
										<div class = "row">
											<div class="col-lg-12">
											<div class="input-group">
											<span class="input-group-addon"><div class="glyphicon glyphicon-credit-card"></div></span>
												<input type="text" class="form-control" required name="eid" ng-model="c.eid" id="eidid" placeholder="Election ID" required/>
												</div>
												<div class="alert hidden alert-danger" id="errorceid">
					 								<br><strong>Error!</strong> Only ten digits allowed.
												</div>
											</div>
										</div>
										<br>
										<div class = "row">
											<div class="col-lg-12">
												<div class="input-group">
													<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" name="electorfname" ng-model="c.fname" id="fnameid" ng-model="fnameid" required class="form-control nodigits" placeholder="Candidate's First Name." required/>
												</div>
												<br>
												<div class="alert hidden alert-danger" id="errorcfname">
			 										<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
												</div>
											</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
												<div class="input-group">
												<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" class="form-control" name="mname" ng-model="c.mname" required id="mnameid" placeholder="Candidate's Middle Name." required/>
												</div>
												<br>	
													<div class="alert hidden alert-danger" id="errorcmname">
					 									<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
												<div class="input-group">
												<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" class="form-control" name="lname" ng-model="c.lname" required id="lnameid" placeholder="Candidate's Last Name." required/>
													
												</div>
													<br>
													<div class="alert hidden alert-danger" id="errorclname">
			 											<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
													</div>
												</div>
												<br>
											</div>
									<div class = "row">
										<div class="col-lg-2"><label><font color = "gray" size="3%">Gender:</font></label></div>
										<div class="col-lg-10">
											<div class ="row">
												<div class="col-lg-2"><label>Male:</label></div><div class="col-lg-2"><input required type="radio" class="radio" name="sex" ng-model="c.sex" value="M" id="sexmale"></div>
												<div class="col-lg-2"><label>Female:</label></div><div class="col-lg-2"><input required type="radio" class = "radio" name="sex" ng-model="c.sex" value="F" id="sexfemale"></div>
												<div class="col-lg-2"><label>Other:</label></div><div class="col-lg-2"><input required type="radio" class="radio" name="sex" ng-model="c.sex" value="O" id="sexother"></div>
											</div>
										</div>
									</div>
								<br>
								<div class = "row ">
									<div class="col-lg-12">
										<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-calendar"></div></span>
											<input type="date" class="form-control date datepicker1" required name="bdate" ng-model="c.bdate" id="bdateid" placeholder="Candidate's  Birth Date." required/>
										</div>
										<div class="alert hidden alert-danger" id="errorbdate">
			 								<br><strong>Error!</strong> You should be 18 year old to register.
										</div>
										</div>
								</div>
								<br>
								<div class = "row">
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-credit-card"></div></span>
										<input type="number" class="form-control" required name="uid" ng-model="c.uid" id="uidid" placeholder="AADHAR Number" required/>
										</div>
										<div class="alert hidden alert-danger" id="errorcaadhar">
			 								<br><strong>Error!</strong> Only twelve digit number allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-phone-alt"></div></span>
										<input type="number" class="form-control" required name="phone" ng-model="c.phone" id="phoneid" placeholder="Phone" required/>
										
									</div>
										
										<div class="alert hidden alert-danger" id="errorcphone">
			 								<br><strong>Error!</strong> Only ten digit number allowed.
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-envelope"></div></span>
										<input type="text" class="form-control" required name="email" ng-model="c.email" id="emailid" placeholder="Email ID" required/>
										
									</div>
										
										<div class="alert hidden alert-danger" id="errorcemail">
			 								<br><strong>Error!</strong> Enter a valid email ID. (Ex.mailme@mail.domainname)
										</div>
									</div>
								</div>
								<br>
								<div class="row">
												<div class="col-lg-12">
												<div class="input-group">
												<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
													<input type="text" class="form-control" name="partyname" ng-model="c.partyname" required id="partynameid" placeholder="Contesting Party Name." required/>
												</div>
												<br>	
													<div class="alert hidden alert-danger" id="errorcpartyname">
					 									<strong>Error!</strong> Only uppercase and lowercase letters are allowed.
													</div>
												</div>
											</div>
								<br>
								<div class = "row ">
									<div class="col-lg-12">
										<div class="input-group">
										<span class="input-group-addon"><div class="glyphicon glyphicon-calendar"></div></span>
											<input type="date" class="form-control date datepicker1" required name="electiondate" ng-model="c.electiondate" id="electiondateid" placeholder="Contesting Election Date" required/>
											
										</div>
										</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control" required name="conteststate" ng-model="c.conteststate" onchange="setcontestDistrict();" id="conteststateid" required>
											<option value="">Election State</option>
										</select>
									</div>
									</div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control" required name="contestdistrict" ng-model="c.contestdistrict" onchange="setcontestSubDistrict();" id="contestdistrictid" required>
											<option value="">Election District</option>
										</select>
									</div></div>
								</div>
								<br>
								<div class = "row">
									
									<div class="col-lg-12">
									<div class="input-group">
									<span class="input-group-addon"><div class="glyphicon glyphicon-flag"></div></span>
										<select class="form-control" name="contestsubdistrict" ng-model="c.contestsubdistrict" id="contestsubdistrictid" required>
											<option value="">Election Town/Village</option>
										</select>
										</div></div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-12">
										<div class="input-group">
											<span class="input-group-addon"><div class="glyphicon glyphicon-user"></div></span>
											<select class="form-control" name="electiontype" ng-model="c.electiontype" id="electiontypeid" required>
												<option value="">Election Type</option>
												<option value="Vidhan Sabha">Vidhan Sabha</option>
												<option value="Lok Sabha">Lok Sabha</option>
												<option value="Municipal Corporation">Municipal Corporation</option>
												<option value="Gram Panchayat">Gram Panchayat</option>
											</select>
										</div>
									</div>
								</div>
								<br>
								<div class = "row">
									<div class="col-lg-5"></div>
									<div class="col-lg-3">
										<div class="btn-group ">					
											<button id="btnAddCandidate" type="button" ng-click="addCandidate()" class="btn btn-md btn-success"> Save</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				</div>
		</div>
		</div>
		
<!----------------------------------------------------------------------------------------------------
	AADHAR Linking Modal
  ---------------------------------------------------------------------------------------------------->
  
		<div ng-controller="aadharCtrl" class="modal fade" id="adhar_linking" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" style="color:red" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Connect with AADHAR</h4>
		        </div>
		        <div class="modal-body">
		        	<div class="row" id="div_adhaarpassword">
		        		<div class="col-lg-2"></div>
		        		<div class="col-lg-8 input-group">
		        			<input type="number" class="form-control" placeholder="Enter the Adhaar Number." id="id_adhaarid" name="nm_adhaarid" ng-model="aadharNumber"/>
		        			<span class="input-group-addon"><span ng-click="connectAadhar()" class="glyphicon glyphicon-arrow-right" id="btn_adhaarid"></span></span>
		        		</div>
		        	</div>
		        </div>
		        <div class="modal-footer">
		        	<a href="#"></a>
		          <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button-->
		          <button type="button" class="btn btn-success" data-dismiss="modal">Next</button-->
		        </div>
		      </div>
		    </div>
		  </div>

<!----------------------------------------------------------------------------------------------------
	Constituency Modal
 ---------------------------------------------------------------------------------------------------->	
		
		 <div ng-controller="constituencyCtrl" class="modal fade" id="constituencyModal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" style="color:red" class="close" data-dismiss="modal">&times;</button>
		          <h4 align="center" class="modal-title">Know your constituency</h4>
		        </div>
		        <div class="modal-body">
		        	<table id="voterDetails" class="table table-striped table-hover">
		      			<tbody>
						<tr class="row">
							<td class="col-lg-4" align="center">Voter ID</td>
							<td class="col-lg-8" align="center">{{e.voterid}}</td>
						</tr>
						<tr class="row">
							<td class="col-lg-4" align="center">Name</td>
							<td class="col-lg-8" align="center">{{e.electorfname}} {{e.electormname}} {{e.electorlname}}</td>
						</tr>
						<tr class="row">
							<td class="col-lg-4" align="center">State</td>
							<td class="col-lg-8" align="center">{{e.prmtAddElectorstate}}</td>
						</tr>
						<tr class="row">
							<td class="col-lg-4" align="center">District</td>
							<td class="col-lg-8" align="center">{{e.prmtAddElectordistrict}}</td>
						</tr>
						<tr class="row">
							<td class="col-lg-4" align="center">Sub-District</td>
							<td class="col-lg-8" align="center">{{e.prmtAddElectorsubdistrict}}</td>
						</tr>
						</tbody>
					</table>
		        </div>
		        <div class="modal-footer">
		        	<a href="#"></a>
		          <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button-->
		        </div>
		      </div>
		    </div>
		  </div>
		  
<!----------------------------------------------------------------------------------------------------
	Contact Us
  ---------------------------------------------------------------------------------------------------->
	<section class="section" id="contactus">
		<div class="container text-center main">
			<div class="well">
				<h3>Contact Us</h3>

				<div>

					<div>
						<label>Contact No.(toll-free):</label> <label>8888-4334-01/02</label>

						<div align="right">
							<label>Email-ID:</label> <label>eci@gov.in</label><br> <label>
							</label> <label>vote@gov.in</label>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         