function authenticate(){
	var voterid=document.getElementById('voteridid').value;
	var voterpassword=document.getElementById('voterpasswordid').value;
	var arr = ["errorvoterid","errorvoterpassword"];
	for(var i in arr){
		$("#"+i+"").addClass('hidden');
	}	
	alert("voterid:"+voterid+"voterpassword:"+voterpassword);
	var ck_voterid = /^[A-Za-z0-9]{10,10}$/;
	var ck_password = /^[A-Za-z0-9]{8,20}$/;
	if(!ck_voterid.test(voterid) || voterid.length!=10){
		$("#errorvoterid").removeClass('hidden');
		$("#voteridid").val('');
	}
	if(!ck_password.test(voterpassword)){
		$("#errorvoterpassword").removeClass('hidden');
		$("#voterpasswordid").val('');
	}
	
	var obj1={
			v_voterid:voterid,
			v_password:voterpassword
	}
	//var obj1=JSON.stringify(obj1);
	$.ajax({
		type:'GET',
		url:'./ovs/login/validate/abc/123',
		data:obj1,
		contentType:'json',
		success:function(){
			alert("success");
		},
		error:function(){
			alert("ERROR!!");
		}
	});
}