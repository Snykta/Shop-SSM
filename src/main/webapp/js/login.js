$(function() {
	$('#logins').click(function() {
		var users =  $('#users').val().trim().length;
		var password = $('#password').val().trim().length;
		if(users==0||password==0){
			layer.msg('请填写密码或账号!', {icon: 5,time: 1500});
		}else{
		$.ajax({
			 url : "/Shop-SSM/login.do",
	         type : "post",
	         data:{
	        	 "users" : $('#users').val().trim(),
	             "password" :  $('#password').val().trim()
	         },
	         dataType: "json",
	         success : function (m) {
	        	console.log(m)
	        	 if(m.state==1){
	        		 location.href="/Shop-SSM/shop-user/index.html"
	        	 }else{
	        		 $('#users').val(""); $('#password').val("");
	        		 layer.msg('登陆失败...', {icon: 5,time: 800});
	        	 }
	            
	         }
		});
		}
		
	});
});