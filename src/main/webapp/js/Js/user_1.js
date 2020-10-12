$(function() {
	var str = ""
	
	function getUsers() {
		$.ajax({
			url : "/Shop-SSM/adminGetByUsers.do",
			type : "get",
			dataType : "json",
			success : function(m) {
				UserList_(m)
				$('#users').append(str)
				
				dels()
			}
			
		})
	}
	
	getUsers()
	
	function UserList_(arry) {
		var num = 1;
		for(var i in arry){
			str+="<tr align='center' class='d godlist'>"
				str+="<td>"+(num++)+"</td>"
				str+="<td>"+arry[i]["users"]+"</td>"
				str+="<td>"+arry[i]["password"]+"</td>"
				str+="<td>"+arry[i]["email"]+"</td>"
				str+="<td>"+arry[i]["iphone"]+"</td>"
				str+="<td>"+arry[i]["address"]+"</td>"
				str+="<td><a class='del' rel='"+arry[i]["id"]+"' href='javascript:;'>删除</a></td>"
				str+="</tr>"
		}
		
	}

	
	
	
    function dels() {
        $(".del").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"这是危险的操作，删除该账户，则账户下的所有信息会全被清除！",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/Shop-SSM/adminDelsUsers.do",
           	         type : "post",
           	         data:{
           	        	 "id" : ids,
           	        	 "shiro_id" : eval("(" + $.cookie('admin-users') + ")")['admin_shiro']
           	         },
           	         dataType : "json",
           	         success : function (m) {
           	        	 console.log(m)
            	        	 if(m.state==-1){
           	        		layer.msg("您的权限不足，无法删除",{
           	                    icon:5,time:3000
           	                });
           	        	 }else if(m.state==1){
           	        		layer.msg("删除成功",{
           	                    icon:1,time:2000
           	                });
           	        		setTimeout("location.href='user_list.html'",1500);
           	        		
           	        	 }else{
           	        		layer.msg("删除失败",{
           	                    icon:5,time:3000
           	                });
           	        	 }
           	         }
           		});
                    
                }
                ,btn2: function(index, layero){
                    layer.msg("已取消",{
                        icon:2,time:1000
                    });
                }
            });
            return false;
        });
	}
	
	
	
	
	
})