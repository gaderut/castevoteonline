/*
$(function() {
	var windowH = $(window).height();
	var wrapperH = $('.main').height();
	if (windowH > wrapperH) {
		$('.main').css({
			'height' : ($(window).height()) + 'px'
		});
	}
	$(window).resize(function() {
		var windowH = $(window).height();
		var wrapperH = $('.main').height();
		var differenceH = windowH - wrapperH;
		var newH = wrapperH + differenceH;
		var truecontentH = $('.main').height();
		if (windowH > truecontentH) {
			$('.main').css('height', (newH) + 'px');
		}
	})
});

*/

/*
if (typeof console === "undefined") {
    console = {
        log: function() { }
    };
}
*/

/*
$(function() {
	$('.datepicker1').datepicker();
});*/

// for birth place
/*var select, option, i,select1;*//*
$(function() {
	select = document.getElementById('electorstateid');
	select1 = document.getElementById('currAddElectorstateid');
	target = "StateName";
	////alert(States.length);
	for (i = 0; i < States.length; i++) {
		option = document.createElement('option');
		option.text = States[i][target];
		option.value = States[i][target];
		////alert(option.text + " " + option.value);
		select.add(option);
		select1.add(option);
	}
});*/

/*
function addUser() {
	var arr = ["errorfname","errormname","errorlname","errorelectorplace","errorrfname","errorrmname","errorrlname","erroraadhar","errorphone","erroremail","errorspmtadd","errorpincode","errorabsentreason"];
	for(var i in arr){
		$("#"+i+"").addClass('hidden');
	}	
	
	var ck_name = /^[A-Za-z ]{3,20}$/;
	var ck_address = /^[A-Za-z0-9]{3,20}$/;
	var ck_reason = /^[A-Za-z]{10,50}$/;
	var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
alert('addUser');
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
	var electorbdate = document.getElementById('electorbdateid').value;
	var bstate = document.getElementById('electorstateid');
	var electorbirthstate = bstate.options[bstate.selectedIndex].value;
	var bdistrict = document.getElementById('electordistrictid');
	var electorbirthdistrict = bdistrict.options[bdistrict.selectedIndex].value;
	var bsubdistrict = document.getElementById('electorsubdistrictid');
	var electorbirthsubdistrict = bsubdistrict.options[bsubdistrict.selectedIndex].value;
	var electorplace = document.getElementById('electorplaceid').value;
	var electorrfname = document.getElementById('electorrfnameid').value;
	var electorrmname = document.getElementById('electorrmnameid').value;
	var electorrlname = document.getElementById('electorrlnameid').value;
	var relation = document.getElementById('electorrelationid');
	var electorrelation = relation.options[relation.selectedIndex].value;
	var electoruid = document.getElementById('electoruidid').value;
	var electorphone = document.getElementById('electorphoneid').value;
	var electoremail = document.getElementById('electoremailid').value;
	var electorpermenantaddress = document.getElementById('electorpermenantaddressid').value;
	var perstate = document.getElementById('prmtAddElectorstateid');
	var prmtAddElectorstate = perstate.options[perstate.selectedIndex].value;
	var perdistrict = document.getElementById('prmtAddElectordistrictid');
	var electorsperdistrict = perdistrict.options[perdistrict.selectedIndex].value;
	var persubdistrict = document.getElementById('prmtAddElectorsubdistrictid');
	var electorspersubdistrict = persubdistrict.options[persubdistrict.selectedIndex].value;
	var electorpincode = document.getElementById('electorpincodeid').value;
	var absentreason = document.getElementById('absentreasonid').value;
	var absentdescription = document.getElementById('absentdescriptionid').value;
	var awaydate = document.getElementById('awaydateid').value;
	var electorcurrentaddress = document.getElementById('electorcurrentaddressid').value;
	alert(electoruid.length+" "+electorphone.length);
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
	if(!ck_address.test(electorplace)){
		$("#errorelectorplace").removeClass('hidden');
		$("#electorplaceid").val('');
	}
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
	if(electoruid.length!=12){
		$("#erroraadhar").removeClass('hidden');
		$("#electoruidid").val('');
	}
	if(electorphone.length!=10){
		$("errorphone").removeClass('hidden');
		$("electorphoneid").val('');
	}
	if(!ck_email.test(electoremail)){
		$("erroremail").removeClass('hidden');
		$("electoremailid").val('');
	}
	if(electorpincode.length!=6){
		$("#errorpincode").removeClass('hidden');
		$("#electorpincodeid").val('');
	}
	
	else{
		alert('false');
		var arr = ["errorfname","errormname","errorlname","errorelectorplace","errorrfname","errorrmname","errorrlname","erroraadhar","errorphone","erroremail","errorspmtadd","errorpincode","errorabsentreason"];
		for(var i in arr){
			$("#"+i+"").addClass('hidden');
		}	
		
		var obj = {
				v_electorfname : electorfname,
				v_electormname : electormname,
				v_electorlname : electorlname,
				v_electorsex : electorsex,
				v_electorbdate : electorbdate,
				v_electorstate : electorbirthstate,
				v_electordistrict : electorbirthdistrict,
				v_electorsubdistrict : electorbirthsubdistrict,
				v_electorplace : electorplace,
				v_electorrfname : electorrfname,
				v_electorrmname : electorrmname,
				v_electorrlname : electorrlname,
				v_electorrelation : electorrelation,
				v_electoruid : electoruid,
				v_electorphone : electorphone,
				v_electoremail : electoremail,
				v_electorpermenantaddress : electorpermenantaddress,
				v_prmtAddElectorstate : prmtAddElectorstate,
				v_prmtAddElectordistrict : electorsperdistrict,
				v_prmtAddElectorsubdistrict : electorspersubdistrict,
				v_electorpincode : electorpincode,
				v_absentreason : absentreason,
				v_absentdescription : absentdescription,
				v_awaydate : awaydate,
				v_electorcurrentaddress : electorcurrentaddress

			}
			
			alert(JSON.stringify(obj));
	}
	

}*/

/////////////////////////////////////////////////////////////*
//comented on 20-05-2016
///////////////////////////////////////////////////////////
/*
function setDistrict() {
	$('#electordistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="SelectDistrict">Select Birth District</option>')
	.val();
	//document.getElementById('electordistrictid').selectedIndex=0;
	var select = document.getElementById("electordistrictid");
	var length = select.options.length;

	////alert('inside function');
	var state = document.getElementById('electorstateid');

	var stateForm = state.selectedIndex;
	console.log(stateForm);
	var districts = [];
	var districtsId = [];
	var j = 0;
	////alert(Districts.length);
	for (i = 0; i < Districts.length; i++) {
		if (Districts[i]["StatesId"] == stateForm) {
			////alert(Districts[i]["DistrictName"]);
			districts[j] = Districts[i]["DistrictName"];
			districtsId[j] = Districts[i]["DistrictId"];
			j++;
			console.log(districtsId[j]);
		}
	}
	for (i = 0; i < districts.length; i++) {
		console.log(districts[i]);
	}
	select = document.getElementById('electordistrictid');
	////alert(districts.length);
	for (i = 0; i < districts.length; i++) {
		option = document.createElement('option');
		option.text = districts[i];
		option.value = districts[i];
		select.add(option);
	}
}

function setSubDistrict() {
	$('#electorsubdistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="Select District">Select Birth Town/village</option>')
	.val();
	var select = document.getElementById("electorsubdistrictid");
	var length = select.options.length;
	
	////alert('inside function');
	var district = document.getElementById('electordistrictid');

	var districtForm = district.selectedIndex;
	console.log(districtForm);
	var subdistricts = [];
	var subdistrictsId =[];
	var j = 0;
	////alert(SubDistricts.length);
	for (i = 0; i < SubDistricts.length; i++) {
		if (SubDistricts[i]["DistrictId"] == districtForm) {
			////alert(SubDistricts[i]["SubDistrictName"]);
			subdistricts[j] = SubDistricts[i]["SubDistrictName"];
			subdistrictsId[j] = SubDistricts[i]["SubDistrictId"];
			j++;
			////alert(subdistricts[i]);

		}
	}
	for (i = 0; i < subdistricts.length; i++) {
		console.log(subdistricts[i]);
	}
	select = document.getElementById('electorsubdistrictid');
	//alert(subdistricts.length);
	for (i = 0; i < subdistricts.length; i++) {
		option = document.createElement('option');
		option.text = subdistricts[i];
		option.value=subdistricts[i];
		select.add(option);
	}
}

var select2;
// for permanent place
$(function() {
	$('.datepicker1').datepicker();
	select = document.getElementById('electorstateid');
	select1 = document.getElementById('currAddElectorstateid');
	select2 = document.getElementById('prmtAddElectorstateid');
	target = "StateName";
	//alert(States.length);
	for (i = 0; i < States.length; i++) {
		option = document.createElement('option');
		option.text = States[i][target];
		option.value = States[i][target];
		//console.log(option.text + " " + option.value);
		select.add(option);
		option1 = document.createElement('option');
		option1.text = States[i][target];
		option1.value = States[i][target];
		select1.add(option1);
		option2 = document.createElement('option');
		option2.text = States[i][target];
		option2.value = States[i][target];
		select2.add(option2);
	}
});

function setpmtDistrict() {
	$('#prmtAddElectordistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="SelectDistrict">Select Permanant District</option>')
	.val();
	//document.getElementById('electordistrictid').selectedIndex=0;
	var select = document.getElementById("prmtAddElectordistrictid");
	var length = select.options.length;

	////alert('inside function');
	var state = document.getElementById('prmtAddElectorstateid');

	var stateForm = state.selectedIndex;
	console.log(stateForm);
	var districts = [];
	var districtsId = [];
	var j = 0;
	////alert(Districts.length);
	for (i = 0; i < Districts.length; i++) {
		if (Districts[i]["StatesId"] == stateForm) {
			////alert(Districts[i]["DistrictName"]);
			districts[j] = Districts[i]["DistrictName"];
			districtsId[j] = Districts[i]["DistrictId"];
			j++;
			////alert(districtsId[j]);
		}
	}
	for (i = 0; i < districts.length; i++) {
		console.log(districts[i]);
	}
	select = document.getElementById('prmtAddElectordistrictid');
	////alert(districts.length);
	for (i = 0; i < districts.length; i++) {
		option = document.createElement('option');
		option.text = districts[i];
		option.value = districts[i];
		select.add(option);
	}
}

function setpmtSubDistrict() {
	$('#prmtAddElectorsubdistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="Select District">Select Permanant Town/village</option>')
	.val();
	var select = document.getElementById("prmtAddElectorsubdistrictid");
	var length = select.options.length;
	
	////alert('inside function');
	var district = document.getElementById('prmtAddElectordistrictid');

	var districtForm = district.selectedIndex;
	console.log(districtForm);
	var subdistricts = [];
	var subdistrictsId =[];
	var j = 0;
	////alert(SubDistricts.length);
	for (i = 0; i < SubDistricts.length; i++) {
		if (SubDistricts[i]["DistrictId"] == districtForm) {
			////alert(SubDistricts[i]["SubDistrictName"]);
			subdistricts[j] = SubDistricts[i]["SubDistrictName"];
			subdistrictsId[j] = SubDistricts[i]["SubDistrictId"];
			j++;
			////alert(subdistricts[i]);

		}
	}
	for (i = 0; i < subdistricts.length; i++) {
		console.log(subdistricts[i]);
	}
	select = document.getElementById('prmtAddElectorsubdistrictid');
	//alert(subdistricts.length);
	for (i = 0; i < subdistricts.length; i++) {
		option = document.createElement('option');
		option.text = subdistricts[i];
		option.value=subdistricts[i];
		select.add(option);
	}
}

function setcurrDistrict() {
	$('#currAddElectordistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="SelectDistrict">Select Current District</option>')
	.val();
	//document.getElementById('electordistrictid').selectedIndex=0;
	var select = document.getElementById("currAddElectordistrictid");
	var length = select.options.length;

	////alert('inside function');
	var state = document.getElementById('currAddElectorstateid');

	var stateForm = state.selectedIndex;
	console.log(stateForm);
	var districts = [];
	var districtsId = [];
	var j = 0;
	////alert(Districts.length);
	for (i = 0; i < Districts.length; i++) {
		if (Districts[i]["StatesId"] == stateForm) {
			////alert(Districts[i]["DistrictName"]);
			districts[j] = Districts[i]["DistrictName"];
			districtsId[j] = Districts[i]["DistrictId"];
			j++;
			////alert(districtsId[j]);
		}
	}
	for (i = 0; i < districts.length; i++) {
		console.log(districts[i]);
	}
	select = document.getElementById('currAddElectordistrictid');
	////alert(districts.length);
	for (i = 0; i < districts.length; i++) {
		option = document.createElement('option');
		option.text = districts[i];
		option.value = districts[i];
		select.add(option);
	}

	}

function setcurrSubDistrict() {
	$('#currtAddElectorsubdistrictid')
	.find('option')
	.remove()
	.end()
	.append('<option value="Select District">Select Current Town/village</option>')
	.val();
	var select = document.getElementById("currAddElectorsubdistrictid");
	var length = select.options.length;
	
	////alert('inside function');
	var district = document.getElementById('currAddElectordistrictid');

	var districtForm = district.selectedIndex;
	console.log(districtForm);
	var subdistricts = [];
	var subdistrictsId =[];
	var j = 0;
	////alert(SubDistricts.length);
	for (i = 0; i < SubDistricts.length; i++) {
		if (SubDistricts[i]["DistrictId"] == districtForm) {
			////alert(SubDistricts[i]["SubDistrictName"]);
			subdistricts[j] = SubDistricts[i]["SubDistrictName"];
			subdistrictsId[j] = SubDistricts[i]["SubDistrictId"];
			j++;
			////alert(subdistricts[i]);

		}
	}
	for (i = 0; i < subdistricts.length; i++) {
		console.log(subdistricts[i]);
	}
	select = document.getElementById('currAddElectorsubdistrictid');
	//alert(subdistricts.length);
	for (i = 0; i < subdistricts.length; i++) {
		option = document.createElement('option');
		option.text = subdistricts[i];
		option.value=subdistricts[i];
		select.add(option);
	}
}
*/
/********************************************************************************************
 * To send OTP and enable scrolling
 ********************************************************************************************/
function fn_sendOTP(){
	alert('inside sendotp');
	$('#div_loginpassword').removeClass('hidden');
	$('#body').removeClass("disabled-scrollbar");
	var login_voter_id = document.getElementById('id_loginvoterid').value;
	alert(login_voter_id);
	$.ajax({
	    url:'./ovs/login/validate/abc/123',
	    type: 'GET',
	    data:{get_param:value},
	    contentType: 'application/json',
	    dataType:'json',
	    success:function(data)
	    {
	        var values = JSON.stringify(data);
	        alert(values);
	    },
	},'json');
}

/********************************************************************************************
 * To upload Photo in candidate form
 ********************************************************************************************/
function upload(input) {
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
        };
}