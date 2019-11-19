var app = angular.module('cyberWarApp', []);

/**********************************************************************************************
 * Prevents use of back button in browser
 **********************************************************************************************/
window.onpopstate = function (e) { window.history.forward(1); }

/**********************************************************************************************
 * Global values
 **********************************************************************************************/
app.factory('globalValue', globalValue);

function globalValue(){
	var voterId;
	
	var setVoterId = function(voterId){
	 this.voterId = voterId;	
	}
	
	var getVoterId = function(){
		return voterId;
	}
	
	return{
		setVoterId: setVoterId,
		getVoterId: getVoterId
	}
}
/**********************************************************************************************
 * Controller for Nav Bar
 **********************************************************************************************/
app.controller('navBarCtrl', function($scope, $http) {
	$('#body').removeClass("disabled-scrollbar");
	$scope.feedback = function() {
//		alert("just started");
	}
});


/**********************************************************************************************
 * Controller for Login Modal
 **********************************************************************************************/
app.controller('loginCtrl', function($scope, $http, $rootScope) {
	// To disable scroll bar
	$('#body').addClass("disabled-scrollbar");
	
	$rootScope.voterId = 'pranay123';
	var voterId = getParameterByName('voterId');
	var requestType = getParameterByName('requestType');
	if(requestType=='redirect'){
		$rootScope.voterId = voterId;
		$("#loginButton").addClass('hidden'); 
	}
	function getParameterByName(name) {
	    url = window.location.href;
	    name = name.replace(/[\[\]]/g, "\\$&");
	    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	        results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, " "));
	}

	//To generate OTP
	$scope.sendOTP = function() {
		$rootScope.voterId = $scope.nm_loginvoterid;
		
		$http.post("http://localhost:8081/testovs/ovs/login/genOTP/"+$scope.nm_loginvoterid).then(function(response) {
			alert("generated OTP is "+response.data);
			$('#div_loginpassword').removeClass('hidden');
		}, function(errResponse){
            console.error('Error while fetching users'+errResponse.data);
        });
	}
	
	//To validate Voter ID and OTP
	$scope.validate = function(){
		$http.post("http://localhost:8081/testovs/ovs/login/validate/"+$scope.nm_loginvoterid+"/"+$scope.nm_loginpassword).then(function(response) {
			if(response.data=="true"){
//				alert("Successful login");
				$('#body').removeClass("disabled-scrollbar");
				$('#loginmodal').modal('hide');
				$('#id_loginvoterid').val("");
				$('#id_loginpassword').val("");
				$("#loginButton").addClass('hidden'); 
			}else{
				alert("incorrect OTP, please try again");
				$('#id_loginpassword').val("");
			}
			
		}, function(errResponse){
			alert("incorrect OTP, please try again");
            console.error('incorrect OTP');
        });
	}
});

/**********************************************************************************************
 * Controller for Voter Options
 **********************************************************************************************/
app.controller('voterOptionsCtrl',['$scope', '$rootScope', '$http', function($scope, $rootScope, $http) {
	$scope.editVoter = function() {
		$rootScope.$emit("CallEditVoter", {});
	}
	
	$scope.getAadhar = function() {
//		alert("in getAadhar, options");
		$rootScope.$emit("CallgetAadhar", {});
	}
	
	$scope.getConstituency = function() {
//		alert("in getConstituency "+$rootScope.voterId);
		$rootScope.$emit("CallgetConstituency", {});
	}
	
	$scope.callVotingHtml = function(requestType) {
		window.open("html/voting.html?voterId="+$rootScope.voterId+"&requestType="+requestType);
//		window.open("html/voting.html?voterId=pranay123&requestType="+requestType);
	}
}]);

/**********************************************************************************************
 * Controller for Voter registration modal
 **********************************************************************************************/
app.controller('voterRegCtrl', ['$scope', '$rootScope', '$http', function($scope, $rootScope, $http) {
	
	// Hide save button of voter registration form
	$("#btnAddUser").addClass('hidden');
	
	$scope.e = {};

	var electorstate = [];
	var electordistrict = [];
	var electorsubdistrict = [];
	var prmtAddElectorstate = [];
	var prmtAddElectordistrict = [];
	var prmtAddElectorsubdistrict = [];
	var currAddElectorstate = [];
	var currAddElectordistrict = [];
	var currAddElectorsubdistrict = [];
	
	for (i = 0; i < States.length; i++) {
		electorstate[i] = States[i].StateName;
		prmtAddElectorstate[i] = States[i].StateName;
		currAddElectorstate[i] = States[i].StateName;
	}
	for (i = 0; i < Districts.length; i++) {
		currAddElectordistrict[i] = Districts[i].DistrictName;
		prmtAddElectordistrict[i] = Districts[i].DistrictName;
		electordistrict[i] = Districts[i].DistrictName;
	}
	for (i = 0; i < SubDistricts.length; i++) {
		electorsubdistrict[i] = SubDistricts[i].SubDistrictName;
		prmtAddElectorsubdistrict[i] = SubDistricts[i].SubDistrictName;
		currAddElectorsubdistrict[i] = SubDistricts[i].SubDistrictName;
	}
	
	select = document.getElementById('electorstateid');
	for (i = 0; i < States.length; i++) {
		option = document.createElement('option');
		option.text = electorstate[i];
		option.value = electorstate[i];
		select.add(option);
	}
	select = document.getElementById('prmtAddElectorstateid');
	for (i = 0; i < States.length; i++) {
		option = document.createElement('option');
		option.text = prmtAddElectorstate[i];
		option.value = prmtAddElectorstate[i];
		select.add(option);
	}
	select = document.getElementById('currAddElectorstateid');
	for (i = 0; i < States.length; i++) {
		option = document.createElement('option');
		option.text = currAddElectorstate[i];
		option.value = currAddElectorstate[i];
		select.add(option);
	}
	select = document.getElementById('electordistrictid');
	for (i = 0; i < Districts.length; i++) {
		option = document.createElement('option');
		option.text = electordistrict[i];
		option.value = electordistrict[i];
		select.add(option);
	}
	select = document.getElementById('prmtAddElectordistrictid');
	for (i = 0; i < Districts.length; i++) {
		option = document.createElement('option');
		option.text = prmtAddElectordistrict[i];
		option.value = prmtAddElectordistrict[i];
		select.add(option);
	}
	select = document.getElementById('currAddElectordistrictid');
	for (i = 0; i < Districts.length; i++) {
		option = document.createElement('option');
		option.text = currAddElectordistrict[i];
		option.value = currAddElectordistrict[i];
		select.add(option);
	}
	select = document.getElementById('electorsubdistrictid');
	for (i = 0; i < SubDistricts.length; i++) {
		option = document.createElement('option');
		option.text = electorsubdistrict[i];
		option.value = electorsubdistrict[i];
		select.add(option);
	}
	select = document.getElementById('prmtAddElectorsubdistrictid');
	for (i = 0; i < SubDistricts.length; i++) {
		option = document.createElement('option');
		option.text = prmtAddElectorsubdistrict[i];
		option.value = prmtAddElectorsubdistrict[i];
		select.add(option);
	}
	select = document.getElementById('currAddElectorsubdistrictid');
	for (i = 0; i < SubDistricts.length; i++) {
		option = document.createElement('option');
		option.text = currAddElectorsubdistrict[i];
		option.value = currAddElectorsubdistrict[i];
		select.add(option);
	}
	
	// To add a Voter
	$scope.addVoter = function() {
			var arr = ["errorfname","errormname","errorlname","errorelectorplace","errorrfname","errorrmname","errorrlname","erroraadhar","errorphone","erroremail","errorspmtadd","errorpincode","errorabsentreason"];
			for(var i in arr){
				$("#"+i+"").addClass('hidden');
			}	
			
			var ck_name = /^[A-Za-z ]{3,20}$/;
			var ck_address = /^[A-Za-z0-9]{3,20}$/;
			var ck_reason = /^[A-Za-z]{10,50}$/;
			var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
//		alert('addUser');
			var electorfname = document.getElementById('electorfnameid').value;
			var electormname = document.getElementById('electormnameid').value;
			var electorlname = document.getElementById('electorlnameid').value;
			var electorsex;
			if (document.getElementById('electorsexmale').checked) {
				gender = 'male';
			} else if (document.getElementById('electorsexfemale').checked) {
				gender = 'female';
			} else {
				gender = 'other';
			}
			var electorbdate = document.getElementById('bdateid').value;
			var electorbdate = document.getElementById('electorbdateid').value;
			var bstate = document.getElementById('electorstateid');
//			var electorbirthstate = bstate.options[bstate.selectedIndex].value;
			var bdistrict = document.getElementById('electordistrictid');
//			var electorbirthdistrict = bdistrict.options[bdistrict.selectedIndex].value;
			var bsubdistrict = document.getElementById('electorsubdistrictid');
//			var electorbirthsubdistrict = bsubdistrict.options[bsubdistrict.selectedIndex].value;
			//var electorplace = document.getElementById('electorplaceid').value;
			var electorrfname = document.getElementById('electorrfnameid').value;
			var electorrmname = document.getElementById('electorrmnameid').value;
			var electorrlname = document.getElementById('electorrlnameid').value;
			var relation = document.getElementById('electorrelationid');
//			var electorrelation = relation.options[relation.selectedIndex].value;
			var electoruid = document.getElementById('electoruidid').value;
			var electorphone = document.getElementById('electorphoneid').value;
			var electoremail = document.getElementById('electoremailid').value;
			var electorpermenantaddress = document.getElementById('electorpermenantaddressid').value;
			var perstate = document.getElementById('prmtAddElectorstateid');
//			var prmtAddElectorstate = perstate.options[perstate.selectedIndex].value;
			var perdistrict = document.getElementById('prmtAddElectordistrictid');
//			var electorsperdistrict = perdistrict.options[perdistrict.selectedIndex].value;
			var persubdistrict = document.getElementById('prmtAddElectorsubdistrictid');
//			var electorspersubdistrict = persubdistrict.options[persubdistrict.selectedIndex].value;
			var electorpincode = document.getElementById('electorpincodeid').value;
			var absentreason = document.getElementById('absentreasonid').value;
			var absentdescription = document.getElementById('absentdescriptionid').value;
			var awaydate = document.getElementById('awaydateid').value;
			var electorcurrentaddress = document.getElementById('electorcurrentaddressid').value;
			//alert(electoruid.length+" "+electorphone.length);
			
			console.log( electorfname+
					 electormname+
					 electorlname+
					 electorbdate+
					 electorrfname+
					 electorrmname+
					 electorrlname+
					
					 electoruid+
					 electorphone+
					 electoremail+
					 
					
					 electorpincode+
						
					 awaydate
					);
			if(!ck_name.test(electorfname)){
				$("#errorfname").removeClass('hidden');
				$("#electorfnameid").val('');
			}
			if(!ck_name.test(electormname)){
				$("#errormname").removeClass('hidden');
				$("#electormnameid").val('');
			}
			if(!ck_name.test(electorlname)){
				$("#errorlname").removeClass('hidden');
				$("#electorlnameid").val('');
			}
//			if(!ck_address.test(electorplace)){
//				$("#errorelectorplace").removeClass('hidden');
//				$("#electorplaceid").val('');
//			}
			if(!ck_name.test(electorrfname)){
				$("#errorrfname").removeClass('hidden');
				$("#electorrfnameid").val('');
			}
			if(!ck_name.test(electorrmname)){
				$("#errorrmname").removeClass('hidden');
				$("#electorrmnameid").val('');
			}
			if(!ck_name.test(electorrlname)){
				$("#errorrlname").removeClass('hidden');
				$("#electorrlnameid").val('');
			}
			if(electoruid.length!=10){
				$("#erroraadhar").removeClass('hidden');
				$("#electoruidid").val('');
			}
			if(electorphone.length!=10){
				$("errorphone").removeClass('hidden');
				$("electorphoneid").val('');
			}
			if(!ck_email.test(electoremail)){
				$("#erroremail").removeClass('hidden');
				$("#electoremailid").val('');
			}
			if(electorpincode.length!=6){
				$("#errorpincode").removeClass('hidden');
				$("#electorpincodeid").val('');
			}
			var ck_date = new Date("21-May-2015");
			var today = ck_date.getDate();
			if(electorbdate<(today-18)){
				$("#errorbdate").removeClass('hidden');
				$("#bdateid")
			}
			
			else{
				//alert('false');
				var arr = ["errorfname","errormname","errorlname","errorelectorplace","errorrfname","errorrmname","errorrlname","erroraadhar","errorphone","erroremail","errorspmtadd","errorpincode","errorabsentreason"];
				for(var i in arr){
					$("#"+i+"").addClass('hidden');
				}	
			}
		
		$http({
	          method  : 'POST',
	          url     : 'http://localhost:8081/testovs/ovs/voter/addVoter',
	          data    : $scope.e, 
	          headers : {'Content-Type' : 'application/json'} 
	         }).then(function(response) {
	        	 alert(response.data);
			if(response.data == "true"){
				alert("Voter added Successfully")
				$('#form1')[0].reset();
			}
			else
				alert("voter entry failed");
			
		}, function(errResponse){
            console.error('Error while registering voter');
        });
	}
	
	//broadcast function
	$rootScope.$on("CallEditVoter", function(){
//		alert("in voterCtrl");
        $scope.editVoter();
     });

	// To display voter details
	$scope.editVoter = function() {
		
//		alert("in edit voter "+$rootScope.voterId);
		$http.get("http://localhost:8081/testovs/ovs/voter/editVoter/"+$rootScope.voterId).then(function(response) {
//			alert("test 8 stringified json "+JSON.stringify(response));
//			alert("test 4 stringified json data "+JSON.stringify(response.data));
			$scope.e = {};
			
			response3 = JSON.parse(JSON.stringify(response));
//			alert("2 parse stringify " + response3.data.electorfname);
			
			$scope.e.electorfname = response3.data.electorfname;
			$scope.e.electormname = response3.data.electormname;
			$scope.e.electorlname = response3.data.electorlname;
			$scope.e.electorsex = response3.data.electorsex;
			$scope.e.electorbdate = response3.data.electorbdate;
			
			$("#electorstateid").val(response3.data.electorstate);
			$("#electordistrictid").val(response3.data.electordistrict);
			$("#electorsubdistrictid").val(response3.data.electorsubdistrict);
			$("#prmtAddElectorstateid").val(response3.data.prmtAddElectorstate);
			$("#prmtAddElectordistrictid").val(response3.data.prmtAddElectordistrict);
			$("#prmtAddElectorsubdistrictid").val(response3.data.prmtAddElectorsubdistrict);
			$("#currAddElectorstateid").val(response3.data.currAddElectorstate);
			$("#currAddElectordistrictid").val(response3.data.currAddElectordistrict);
			$("#currAddElectorsubdistrictid").val(response3.data.currAddElectorsubdistrict);
			
			$scope.e.electorbirthplace = response3.data.electorbirthplace;
			$scope.e.electorrfname = response3.data.electorrfname;
			$scope.e.electorrmname = response3.data.electorrmname;
			$scope.e.electorrlname = response3.data.electorrlname;
			$scope.e.electorrelation = response3.data.electorrelation;
			$scope.e.electoruid = response3.data.electoruid;
			$scope.e.electorphone = response3.data.electorphone;
			$scope.e.electoremail = response3.data.electoremail;
			$scope.e.electorpermenantaddress = response3.data.electorpermenantaddress;
			
			$scope.e.electorpincode = response3.data.electorpincode;
			$scope.e.absentreason = response3.data.absentreason;
			$scope.e.absentdescription = response3.data.absentdescription;
			$scope.e.awaydate = response3.data.awaydate;
			$scope.e.electorcurrentaddress = response3.data.electorcurrentaddress;
			$scope.e.currelectorpincode = response3.data.currelectorpincode;
		});
	}
	
	$scope.addFingerPrint = function(){
//		alert("in addFingerPrint()");
		var path = document.getElementById("fingerPrintid").files[0].name;
//		alert("path "+$rootScope.voterId+"/"+path);
//		$http.post("http://localhost:8081/testovs/ovs/voter/addFingerPrint/"+$rootScope.voterId+"/"+path)
		$scope.f ={};
		$scope.f.voterId = $scope.e.electorfname+"123";
		$scope.f.fingerPrintPath =  path;
//		alert($scope.f.voterId+"/"+$scope.f.fingerPrintPath);
		$http({
	          method  : 'POST',
	          url     : 'http://localhost:8081/testovs/ovs/voter/addFingerPrint',
	          data    : $scope.f, 
	          headers : {'Content-Type' : 'application/json'} 
	         }).then(function(response) {
	        	 if(response.data == "false"){
	        		 alert("The finger Print image is not stored, please try again");
	        		 
	        }else{
	        	$("#btnAddUser").removeClass('hidden');
	        }
        });
	}
}]);

/**********************************************************************************************
 * Controller for Candidate registration modal
 **********************************************************************************************/
app.controller('candidateRegCtrl', function($scope, $http) {
//	alert(""+JSON.stringify(Districts));
	var states = [];
	var districts = [];
	var subdistricts = [];
	
	for (i = 0; i < States.length; i++) {
		states[i] = States[i].StateName;
	}
	for (i = 0; i < Districts.length; i++) {
		districts[i] = Districts[i].DistrictName;
	}
	for (i = 0; i < SubDistricts.length; i++) {
		subdistricts[i] = SubDistricts[i].SubDistrictName;
	}
	
	select = document.getElementById('conteststateid');
	for (i = 0; i < states.length; i++) {
		option = document.createElement('option');
		option.text = states[i];
		option.value = states[i];
		select.add(option);
	}
	select = document.getElementById('contestdistrictid');
	for (i = 0; i < districts.length; i++) {
		option = document.createElement('option');
		option.text = districts[i];
		option.value = districts[i];
		select.add(option);
	}
	select = document.getElementById('contestsubdistrictid');
	for (i = 0; i < subdistricts.length; i++) {
		option = document.createElement('option');
		option.text = subdistricts[i];
		option.value = subdistricts[i];
		select.add(option);
	}
	
	$scope.c = {};
	// To add a Candidate
	$scope.addCandidate = function() {
		$http({
	          method  : 'POST',
	          url     : 'http://localhost:8081/testovs/ovs/voter/addCandidate',
	          data    : $scope.c, 
	          headers : {'Content-Type' : 'application/json'} 
	         }).then(function(response) {
//	        	 alert(response.data);
			if(response.data=="true"){
				alert("Candidate added Successfully")
				$('#form2')[0].reset();
				}
			else
				alert("candidate entry failed");
		}, function(errResponse){
          console.error('Error while registering candidate');
      });
	}
	
	// To display candidate details
	$scope.editCandidate = function() {
//		alert("in edit candidate "+$rootScope.voterId);
		$http.get("http://localhost:8081/testovs/ovs/voter/editCandidate/"+$rootScope.voterId).then(function(response) {
//			alert("test 4 stringified json "+JSON.stringify(response));
//			alert("test 4 stringified json data "+JSON.stringify(response.data));
			$scope.c = {};
			
			response3 = JSON.parse(JSON.stringify(response));
//			alert("1 parse stringify " + response3.data.electorfname);
			$scope.c.eid = $rootScope.voterId;
			$scope.c.profilephoto = response3.data.profilephoto;
			$scope.c.fname = response3.data.fname;
			$scope.c.mname = response3.data.mname;
			$scope.c.lname = response3.data.lname;
			$scope.c.sex = response3.data.sex;
			$scope.c.bdate = response3.data.bdate;
			$scope.c.uid = response3.data.uid;
			$scope.c.phone = response3.data.phone;
			$scope.c.email = response3.data.email;
			$scope.c.partyname = response3.data.partyname;
			$scope.c.electiondate = response3.data.electiondate;
			$scope.c.conteststate = response3.data.conteststate;
			$scope.c.contestdistrict = response3.data.contestdistrict;
			$scope.c.contestsubdistrict = response3.data.contestsubdistrict;
			$scope.c.electiontype = response3.data.electiontype;
		});
	}
});

/**********************************************************************************************
 * Controller for Aadhar linking modal
 **********************************************************************************************/
app.controller('aadharCtrl', ['$scope', '$rootScope', '$http', function($scope, $rootScope, $http) {
	
	//broadcast function
	$rootScope.$on("CallgetAadhar", function(){
//		alert("in aadharCtrl");
		$scope.getAadhar();
     });
	
	// To connect aadhar number with voterID
	$scope.getAadhar = function() {
//		alert("in getAadhar "+$rootScope.voterId);
		$http.post("http://localhost:8081/testovs/ovs/voter/getAadhar/"+$rootScope.voterId).then(function(response) {
			alert("aadhar response "+JSON.stringify(response));
			if(response.data != null || response.data !=""){
//				alert("your stored AADHAR No. is "+response.data+"\n Do you want to change it ?");
			}
		});
	}
	
	$scope.connectAadhar = function() {
//		alert("in connect to aadhar "+$rootScope.voterId+" "+$scope.aadharNumber);
		$http.post("http://localhost:8081/testovs/ovs/voter/connectAadhar/"+$rootScope.voterId+"/"+$scope.aadharNumber).then(function(response) {
//			alert("aadhar response "+JSON.stringify(response));
			if(response.data == "true"){
				alert("aadhar no. changed succesfully");
				$('#id_adhaarid').val("");
			}
		});
	}
}]);

/**********************************************************************************************
 * Controller for finding voter's constituency modal
 **********************************************************************************************/
app.controller('constituencyCtrl', ['$scope', '$rootScope', '$http', function($scope, $rootScope, $http) {
	
	//broadcast function
	$rootScope.$on("CallgetConstituency", function(){
//		alert("in constituencyCtrl");
		$scope.getConstituency();
     });
	
	$scope.getConstituency = function() {
//		alert("in getConstituency, constituencyCtrl "+$rootScope.voterId);
		$http.get("http://localhost:8081/testovs/ovs/voter/getConstituency/"+$rootScope.voterId).then(function(response) {
//			alert("stringified voter details"+JSON.stringify(response));
			$scope.e = {};
			$scope.e.electorfname = response.data.electorfname;
			$scope.e.electormname = response.data.electormname;
			$scope.e.electorlname = response.data.electorlname;
			$scope.e.prmtAddElectorstate = response.data.prmtAddElectorstate;
			$scope.e.prmtAddElectordistrict = response.data.prmtAddElectordistrict;
			$scope.e.prmtAddElectorsubdistrict = response.data.prmtAddElectorsubdistrict;
			$scope.e.voterid = $rootScope.voterId;
		});
	}
	
}]);
/**********************************************************************************************
 * Controller for Feedback Form
 **********************************************************************************************/
app.controller('feedbackFormCtrl', ['$scope', '$rootScope', '$http', function($scope, $rootScope, $http) {
	// To submit feedback from user
	$scope.submitFeedback = function() {
//		alert("in feedbackFormCtrl "+$rootScope.voterId);
		$http.post("http://localhost:8081/testovs/ovs/voter/submitFeedback/"+$rootScope.voterId+"/"+$scope.feedback).then(function(response) {
			if(response.data)
			alert("Feedback submitted successfully")
			$('#feedbackid').val("");
		}, function(errResponse){
			alert("feedback submission unsuccessful");
			$('#feedbackid').val("");
        });
	}
}]);

/**********************************************************************************************
 * Controller for voting modal
 **********************************************************************************************/
app.controller('votingCtrl', function($scope, $http) {
	
	//To get candidate list particular to voter's constituency
	$scope.getCandidateList = function(){
		$http.get("http://localhost:8081/testovs/ovs/voter/editVoter/"+$rootScope.voterId).then(function(response) {
			$scope.candidateList = response;
		});
	}
	
	// To cast vote
	$scope.castVote = function() {
		$http({
	          method  : 'POST',
	          url     : 'http://localhost:8081/testovs/ovs/voter/castVote',
	          data    : $scope.v, 
	          headers : {'Content-Type' : 'application/json'} 
	         }).then(function(response) {
	        	 alert(response.data);
			if(response.data)
				alert("Vote Casted Successfully")
			else
				alert("vote casting failed");
		}, function(errResponse){
            console.error('Error while casting vote');
        });
	}
});