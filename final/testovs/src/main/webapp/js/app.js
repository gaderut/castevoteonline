var app = angular.module('cyberWarApp', []);
/*
app.directive('modal', function () {
   return {
     template: '<div class="modal fade">' + 
         '<div class="modal-dialog">' + 
           '<div class="modal-content">' + 
             '<div class="modal-header">' + 
               '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'+ 
               '<h4 class="modal-title">{{ title }}</h4>' + 
             '</div>' + 
             '<div class="modal-body" ng-transclude></div>' + 
           '</div>' + 
         '</div>' + 
       '</div>',
     restrict: 'E',
     transclude: true,
     replace:true,
     scope:true,
     link: function postLink(scope, element, attrs) {
       scope.title = attrs.title;

       scope.$watch(attrs.visible, function(value){
         if(value == true)
           $(element).modal('show');
         else
           $(element).modal('hide');
       });

       $(element).on('shown.bs.modal', function(){
         scope.$apply(function(){
           scope.$parent[attrs.visible] = true;
         });
       });

       $(element).on('hidden.bs.modal', function(){
         scope.$apply(function(){
           scope.$parent[attrs.visible] = false;
         });
       });
     }
   };
 });

app.controller('navCtrl', function($scope) {
});
app.controller('homeCtrl', function($scope) {
});

app.controller('voterCtrl', function($scope) {
alert("hey!");
 $scope.voterRegisterForm = false;
   $scope.showVoterRegisterForm = function(){
       $scope.voterRegisterForm = !$scope.voterRegisterForm;
   };
});*/

var v_electorfname = null;
var v_electormname = null;
var v_electorlname = null;
var v_electorsex = null;
var v_electorbdate = null;
var v_electorstate = null;
var v_electordistrict = null;
var v_electortown = null;
var v_electorbirthplace = null;
var v_electorrfname = null;
var v_electorrmname = null;
var v_electorrlname = null;
var v_electorrelation = null;
var v_electoruid = null;
var v_electorphone = null;
var v_electoremail = null;
var v_electorpermenantaddress = null;
var v_prmtAddElectorstate = null;
var v_prmtAddElectordistrict = null;
var v_prmtAddElectorsubdistrict = null;
var v_electorpincode = null;
var v_absentreason = null;
var v_absentdescription = null;
var v_awaydate = null;
var v_electorcurrentaddress = null;
var v_currAddElectorstate = null;
var v_currAddElectordistrict = null;
var v_currAddElectorsubdistrict = null;
var v_currelectorpincode = null;
var re = null;
function validate() {
	v_electorfname = document.getElementById('electorfnameid').value;
	v_electormname = document.getElementById('electormnameid').value;
	v_electorlname = document.getElementById('electorlnameid').value;
	if(document.getElementById('electorsexmale').checked){
		v_electorsex = 'Male';
	}
	else if(document.getElementById('electorsexfemale').checked){
		v_electorsex = 'Female';
	}
	else{
		v_electorsex = 'Other';
	}
	v_electorbdate = document.getElementById('electorbdateid').value;
	v_electorstate = document.getElementById('electorstateid').value;
	v_electordistrict = document.getElementById('electordistrictid').value;
	//v_electortown = document.getElementById('electortownid').value;
	v_electorbirthplace = document.getElementById('electorbirthplaceid').value;
	v_electorrfname = document.getElementById('electorrfnameid').value;
	v_electorrmname = document.getElementById('electorrmnameid').value;
	v_electorrlname = document.getElementById('electorrlnameid').value;
	v_electorrelation = document.getElementById('electorrelationid').value;
	v_electoruid = document.getElementById('electoruidid').value;
	v_electorphone = document.getElementById('electorphoneid').value;
	v_electoremail = document.getElementById('electoremailid').value;
	v_electorpermenantaddress = document.getElementById('electorpermenantaddressid').value;
	v_prmtAddElectorstate = document.getElementById('prmtAddElectorstateid').value;
	v_prmtAddElectordistrict = document.getElementById('prmtAddElectordistrictid').value;
	v_prmtAddElectorsubdistrict = document.getElementById('prmtAddElectorsubdistrictid').value;
	v_electorpincode = document.getElementById('electorpincodeid').value;
	v_absentreason = document.getElementById('absentreasonid').value;
	v_absentdescription = document.getElementById('absentdescriptionid').value;
	v_awaydate = document.getElementById('awaydateid').value;
	v_electorcurrentaddress = document.getElementById('electorcurrentaddressid').value;
	v_currAddElectorstate = document.getElementById('currAddElectorstateid').value;
	v_currAddElectordistrict = document.getElementById('currAddElectordistrictid').value;
	v_currAddElectorsubdistrict = document.getElementById('currAddElectorsubdistrictid').value;
	v_currelectorpincode = document.getElementById('currelectorpincodeid').value;
	re=/^[A-Za-z ]{3,20}$/;
	if(!v_electorfname==" " || !v_electorfname==null){
		if(re.test(v_electorfname)==false){
			$("#errorfname").removeClass('hidden');
		}
	}
	if(!v_electormname==" " || !v_electormname==null){
		if(re. test(v_electormname)==false){
			$("#errormname").removeClass('hidden');
		}
	}
	if(!v_electorlname==" " || !v_electorlname==null){
		if(re.test(v_electorlname)==false){
			$("#errorlname").removeClass('hidden');
		}
	}
	if(!v_electorrfname==" " || !v_electorrfname==null){
		if(re.test(v_electorrfname)==false){
			$("#errorrfname").removeClass('hidden');
		}
	}
	if(!v_electorrmname==" " || !v_electorrmname==null){
		if(re.test(v_electorrmname)==false){
			$("#errorrmname").removeClass('hidden');
		}
	}
	if(!v_electorrlname==" " || !v_electorrlname==null){
		if(re.test(v_electorrlname)==false){
			$("#errorrlname").removeClass('hidden');
		}
	}
	re=/^[A-Za-z0-9]{3,30}$/;
	
	if(!v_electorbirthplace==" " || !v_electorbirthplace==null){
		if(re.test(v_electorrlname)==false){
			$("#errorelectorbirthplace").removeClass('hidden');
		}
	}

	if(v_absentreason == " " || !v_absentreason == null){
		if(v_absentreason.length<10 || v_absentreason >30){
			$("#errorabsentreason").removeClass('hidden');
		}
	}
	
	if(!v_electorpermenantaddress== "" || !v_electorpermenantaddress==null){
		if(re.test(v_electorpermenantaddress)==false){
			$("#errorspmtadd").removeClass('hidden');
		}
	}
	
	if(!v_electorcurrentaddress== "" || !v_electorcurrentaddress==null){
		if(re.test(v_electorcurrentaddress)==false){
			$("#errorcurrentadd").removeClass('hidden');
		}
	}
	re=/[0-9]+/;
	
	if(!v_electoruid == " " || !v_electoruid==null){
		if(v_electoruid.length<12 ||v_electoruid.length>12 || re.test(v_electoruid)==false){
			$("#erroraadhar").removeClass('hidden');
		}
	}
	
	if(!v_electorphone == "" || !v_electorphone==null){
		if(v_electorphone.length<10 ||v_electorphone.length>10 || re.test(v_electorphone)==false){
			$("#errorphone").removeClass('hidden');
		}
	}
	
	if(!v_electorpincode == " " || !v_electorpincode==null){
		if(v_electorpincode.length<6||v_electorpincode.length>6 || re.test(v_electorpincode)==false){
			$("#errorpincode").removeClass('hidden');
		}
	}
	
	if(!v_currelectorpincode == " " || !v_currelectorpincode==null){
		if(v_currelectorpincode.length<6||v_currelectorpincode.length>6  || re.test(v_currelectorpincode)==false){
			$("#errorcurrpincode").removeClass('hidden');
		}
	}
	re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	
	if(!v_electoremail == "" || !v_electoremail==null){
		if(re.test(v_electoremail)){
			$("#erroremail").removeClass('hidden');
		}
	}	
	
	var voterObject ={
			j_electorfname:v_electorfname,
			j_electormname:v_electormname,
			j_electorlname:v_electorlname,
			j_electorsex:v_electorsex,
			j_electorbdate:v_electorbdate,
			j_electorstate:v_electorstate,
			j_electordistrict:v_electordistrict,
			j_electorbirthplace:v_electorbirthplace,
			j_electorrfname:v_electorrfname,
			j_electorrmname:v_electorrmname,
			j_electorrlname:v_electorrlname,
			j_electorrelation:v_electorrelation,
			j_electoruid:v_electoruid,
			j_electorphone:v_electorphone,
			j_electoremail:v_electoremail,
			j_electorpermenantaddress:v_electorpermenantaddress,
			j_prmtAddElectorstate:v_prmtAddElectorstate,
			j_prmtAddElectordistrict:v_prmtAddElectordistrict,
			j_prmtAddElectorsubdistrict:v_prmtAddElectorsubdistrict,
			j_electorpincode:v_electorpincode,
			j_absentreason:v_absentreason,
			j_absentdescription:v_absentdescription,			
			j_awaydate:v_awaydate,
			j_electorcurrentaddress:v_electorcurrentaddress,
			j_currAddElectorstate:v_currAddElectorstate,
			j_currAddElectordistrict:v_currAddElectordistrict,
			j_currAddElectorsubdistrict:v_currAddElectorsubdistrict,
			j_currelectorpincode:v_currelectorpincode
	}
	var voter_json_object = JSON.stringify(voterObject);
	console.log(voter_json_object);
	
	$.ajax({
	    url:'./webapi/handleData/addVoter',
	    type: 'POST',
	    data:voter_json_object,
	    contentType: 'application/json',
	    dataType:'json',
	    success:function(data)
	    {
	        var values = JSON.stringify(data);
	        alert(values);
	    },
	},'json');
	
	
	/***********************************************
	js for uploading a photo
	************************************************/
	$(function () {
			    $(":file").change(function () {
			    	alert("1");
			        if (this.files && this.files[0]) {
			        	alert("2");
			        	var reader = new FileReader();
			            reader.onload = imageIsLoaded;
			            reader.readAsDataURL(this.files[0]);
			        }
			    });
			});
		
			function imageIsLoaded(e) {
			    $('#profilephotoid').attr('src', e.target.result);
			};
			
		/*	function upload(input) {
				alert("1");
	            if (input.files && input.files[0]) {
	                var reader = new FileReader();

	                reader.onload = function (e) {
	                    $('#profilephotoid')
	                        .attr('src', e.target.result)
	                        .width(150)
	                        .height(200);
	                };

	                reader.readAsDataURL(input.files[0]);
	            }
	        }*/
			/****************************************
			controller in app.js for candidate registration
			***************************************/
			app.controller('candidateRegistrationCtrl', function($scope, $http) {
				$scope.validateCand = function() {
					re=/[A-Za-z0-9]{10}$/;
					v_eid = $scope.c.eid;
					if(!v_eid == " " || !v_eid==null){
						if(v_eid.length<10 ||v_eid.length>10 || re.test(v_eid)==false){
							$("#errorceid").removeClass('hidden');
						}
					}
					v_fname = $scope.c.fname;
					re=/^[A-Za-z ]{3,20}$/;
					if(!v_fname==" " || !v_fname==null){
						if(re.test(v_fname)==false){
							$("#errorcfname").removeClass('hidden');
						}
					}
					v_mname = $scope.c.mname;
					if(!v_mname==" " || !v_mname==null){
						if(re. test(v_mname)==false){
							$("#errorcmname").removeClass('hidden');
						}
					}
					v_lname = $scope.c.lname;
					if(!v_lname==" " || !v_lname==null){
						if(re.test(v_lname)==false){
							$("#errorclname").removeClass('hidden');
						}
					}
					re=/[0-9]+/;
					v_uid = $scope.c.uid;
					if(!v_uid == " " || !v_uid==null){
						if(v_uid.length<12 ||v_uid.length>12 || re.test(v_uid)==false){
							$("#errorcaadhar").removeClass('hidden');
						}
					}
					v_phone = $scope.c.phone;
					if(!v_phone == "" || !v_phone==null){
						if(v_phone.length<10 ||v_phone.length>10 || re.test(v_phone)==false){
							$("#errorcphone").removeClass('hidden');
						}
					}
					re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
					v_email = $scope.c.email;
					if(!v_email == "" || !v_email==null){
						if(re.test(v_email)){
							$("#errorcemail").removeClass('hidden');
						}
					}	
					
					var voter_json_object = JSON.stringify($scope.c);
					alert(voter_json_object);
				}
				});
			
			app.controller('loginController', function($scope, $http) {
				$scope.login = function() {
					alert("hey pranay");
					$http({
				        method : "GET",
				        url : "ovs/login/validate/abc/123"
				    }).then(function mySucces(response) {
				    	alert("resposnse is "+response.data);
//				        $scope.myWelcome = response.data;
				    });
				}
				});
}
