$(function(){

	var error_address = false;
	var error_email = false;
	var error_iphone = false;
	

	$('#address').blur(function() {
		check_address();
	});


	
	$('#iphones').blur(function() {
		check_iphon()
	});

	$('#email').blur(function() {
		check_email();
	});


	function check_address(){
		var len = $('#address').val().trim().length;
		if(len<5||len>20)
		{
			$('#address').next().html('请输入5-20个字符')
			$('#address').next().show();
			error_address = true;
		}
		else
		{
			$('#address').next().hide();
			error_address = false;
		}
	}



	function check_email(){
		var re = /^[a-z0-9][\w\.\-]*@[a-z0-9\-]+(\.[a-z]{2,5}){1,2}$/;

		if(re.test($('#email').val()))
		{
			$('#email').next().hide();
			error_email = false;
		}
		else
		{
			$('#email').next().html('邮箱格式不正确')
			$('#email').next().show();
			error_check_password = true;
		}

	}
	
	
	function check_iphon(){
		var re = /^1[3456789]\d{9}$/;  

		if(re.test($('#iphones').val()))
		{
			$('#iphones').next().hide();
			error_iphone = false;
		}
		else
		{
			$('#iphones').next().html('手机格式不正确')
			$('#iphones').next().show();
			error_iphone = true;
		}

	}
	


	$('#reg_form').submit(function() {
		check_address();
		check_iphon();
		check_email();

		if(error_address == false && error_iphone == false && error_email == false)
		{
			return true;
			
		}
		else
		{
			return false;
		}

	});
	
	
	
	$('#updatePwd').click(function() {
		var oldPwd = $('#pwd').val().trim().length;
		var newPwd = $('#newpwd').val().trim().length;
		if(oldPwd==0||newPwd==0){
			layer.msg('请填写密码或账号!', {icon: 5,time: 1500});
		}else{
			$.ajax({
				 url : "/Shop-SSM/updatePwds.do",
		         type : "post",
		         data:{
		        	 "id" : eval("(" + $.cookie('shop-users') + ")")['id'],
		        	 "oldPwd" : $('#pwd').val().trim(),
		             "password" :  $('#newpwd').val().trim()
		         },
		         dataType: "json",
		         success : function (m) {
		        	console.log(m)
		        	 if(m.state==0){
		        		 layer.msg('原密码输入错误', {icon: 5,time: 800});
		        		 $('#pwd').val("");$('#newpwd').val("");
		        	 }else if(m.state==1){
		        		 layer.msg('密码修改成功');
		        		 setTimeout("location.href='user_center_info.html'",1000);
		        	 }else{
		        		 layer.msg('修改失败', {icon: 5,time: 1000});
		        	 }
		            
		         }
			});
		}
		
	});
	
	


})