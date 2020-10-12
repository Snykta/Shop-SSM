$(function() {
	var str = ""
	
	function dai() {
		$.ajax({
			url : "/Shop-SSM/AdminGtByorderId.do",
			type : "post",
			data : {
				"id" : GetQueryString("id")
			},
			dataType : "json",
			success : function(m) {
				daiList_(m)
				$('#goods').append(str)
				dels()
			}
			
		})
	}
	
	dai()
	
	function daiList_(arry) {
		var num = 1;
		for(var i in arry){
			str+="<tr align='center' class='d godlist'>"
				str+="<td>"+(num++)+"</td>"
				str+="<td>"+arry[i]["goods_name"]+"</td>"
				str+="<td>"+arry[i]["goods_num"]+"/件</td>"
				str+="<td>"+arry[i]["order_counts"]+"/元</td>"
				str+="<td>"+arry[i]["order_code"]+"</td>"
				str+="<td>"+arry[i]["pay_type"]+"</td>"
				str+="<td><a class='del' rel='"+arry[i]["id"]+"' href='javascript:;'>删除</a></td>"
				str+="</tr>"
		}
		
	}
	
	
	
	
	
    function dels() {
        $(".del").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"确认删除该订单吗？",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/Shop-SSM/adminDaiDels.do",
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
           	        		setTimeout("location.href='orders_yi.html'",1500);
           	        		
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