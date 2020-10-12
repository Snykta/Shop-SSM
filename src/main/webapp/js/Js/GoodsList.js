$(function() {

	var str = ""
	var counts = 0

	$.ajax({
		url : "/Shop-SSM/AdminGetCounts.do",
		type : "get",
		dataType : "json",
		success : function(m) {
			counts = m.count
			pages_();//防止每次刷新时，值不能及时赋值进去

		}
	});
	
	goodsPage(0)
	
	
	function goodsPage(n) {
		$.ajax({
			url : "/Shop-SSM/adminListPage.do",
			type : "post",
			data : {
				"num" : n
			},
			dataType : "json",
			success : function(m) {
				console.log(m)
				lists_(m)
				$('#goods').append(str)
				dels()
			}
			
		})
		
	}
	
	
	
	function lists_(arry) {
		var num=1
		for(var i in arry){
			str+="<tr align='center' class='d godlist'>"
			str+="<td><input class='ck' type='checkbox' value='"+arry[i]["id"]+"' /></td>"
			str+="<td>"+(num++)+"</td>"
			str+="<td>"+arry[i]["goods_name"]+"</td>"
			str+="<td>"+arry[i]["goods_price"]+"</td>"
			str+="<td>"+arry[i]["goodsType"]["type_name"]+"</td>"
			str+="<td>"+arry[i]["goods_stock"]+"/件</td>"
			str+="<td>"+arry[i]["goods_unit"]+"</td>"
			str+="<td><a href='goods_update.html?id="+arry[i]["id"]+"'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class='del' rel='"+arry[i]["id"]+"' href='javascript:;'>删除</a></td>"
			str+="</tr>"
		}
		
	}
	
	function pages_() {
		layui.use('laypage', function(){
		    var laypage = layui.laypage;
		    //执行一个laypage实例
		    laypage.render({
		        elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
		        ,count: counts //数据总数，从服务端得到
		        ,limit :8
		        ,groups :3
		        ,jump: function(obj, first){
		            if(!first){
		            	$('.godlist').text('');
		        		str = "";
		        		goodsPage((obj.curr-1)*8);
		            }
		        }
		    });
		});
	}
	
	
	
	
    function dels() {
        $(".del").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"确认删除 ID 为："+$(this).attr("rel")+" 的信息吗？",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/Shop-SSM/adminDelgoods.do",
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
           	        		setTimeout("location.href='goods_list.html'",1500);
           	        		
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
    
    $('#checks').click(function() {//全选/反选
		$('.ck').each(function(index,element) {
			if($('#checks').is(':checked')){
				$('.ck').get(index).checked=true;
			}else{
				$('.ck').get(index).checked=false;
			}
		})
	})
	
	var sum = 0;
	$('#ckdel').click(function() {
		var num ="";
		$('.ck').each(function(index,element) {
			if($('.ck').get(index).checked){
				sum++;
				num+=$(this).val()+","
			}	
		})
		if(sum==0){
			layer.msg('请先选中数据', {icon: 5,time: 800});
			 return false;
		}else{
		    layer.open({
	            icon:3,
	            content:"确认删除该"+sum+"条信息吗？",
	            title:"确认删除",
	            btn: ['确定', '取消'],
	            yes: function(index, layero){
	        		$.ajax({
	       			 url : "/Shop-SSM/admindelsGood.do",
	       	         type : "post",
	       	         data:{
	       	        	 "ids" : num,
	       	        	 "shiro_id" : eval("(" + $.cookie('admin-users') + ")")['admin_shiro']
	       	         },
	       	         dataType : "json",
	       	         success : function (m) {

	      	        	 if(m.state==-1){
	      	        		layer.msg("您的权限不足，无法删除",{
           	                    icon:5,time:3000})
	       	        	 }else if(m.state==1){
	           	        		layer.msg("删除成功",{
	           	                    icon:1,time:2000
	           	                });
	           	        		setTimeout("location.href='goods_list.html'",1500);
	       	        	 }else{
	           	        		layer.msg("删除失败",{
	           	                    icon:5,time:3000
	           	                });
	       	        	 }
	       	         } 
	       		});
	                
	            }
	            ,btn2: function(index, layero){
	            	sum = 0;
	            	num = "";
	                layer.msg("已取消",{
	                    icon:2,time:1000
	                });
	            }
	        });
		}
	})
			
})