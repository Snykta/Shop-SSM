$(function() {
	var str = ""
	var count = 0	
		$.ajax({
			url : "/Shop-SSM/getCounts.do",
			type :"post",
			data: {
				"num" : eval("(" + $.cookie('shop-users') + ")")['id']
			},
			dataType : "json",
			success : function(m) {
				count = m.state
				pages_();
				
				}
			});
	
	
	function get_orders(pages) {
		$.ajax({
			url : "/Shop-SSM/FenyeLists.do",
			type : "post",
			data : {
				"page" : pages,
				"shiro_id" : eval("(" + $.cookie('shop-users') + ")")['id']
			},
			dataType : "json",
			success : function(m) {
				console.log(m)
				orderlist(m)
				$('#carts').append(str)
				dd()
				pay_s()
			}
		})
		
	}
		
	
		
	function orderlist(arry) {
		for(var i in arry){
		str+="<ul class='order_list_th w978 clearfix'>"
		str+="<li class='col01'>"+arry[i]["order_date"]+"</li>"
		str+="<li class='col02'>订单号："+arry[i]["order_code"]+"</li></ul>"
		str+="<table class='order_list_table w980'>"
		str+="<tbody><tr><td width='55%'><ul class='order_goods_list clearfix'>"
		str+="<li class='col01'><img src='../images/goods02.jpg'></li>"
		str+="<li class='col02'>"+arry[i]["goods_name"]+"</li>"
		str+="<li class='col03' id='shu'>"+arry[i]["goods_num"]+"</li>"
		str+="<li class='col04' id='dan'>"+arry[i]["goods_price"]+"元</li>"
		str+="</ul></td>"
		str+="<td width='15%'><em>"+arry[i]["order_counts"]+"</em>元</td>"
		if(arry[i]["order_succ"]==1){
			str+="<td width='12%'>已付款</td>"
			str+="<td width='10%'><a href='#' class='oper_btn'>"+arry[i]["order_state"]+"</a></td>"	
		}else{
			str+="<td width='12%' style='color:red'>待付款</td>"
			str+="<td width='10%'><a href='javascript:;' rel='"+arry[i]["id"]+"' id='pay_' class='oper_btn' style='color:red'>立即付款</a></td>"
		}
		str+="<td width='15%'><a rel='"+arry[i]["id"]+"' href='javascript:;' class='oper_btn order_del'>删除</a></td>"
		str+="</tr></tbody></table>"
		}
	}
	get_orders(0)
	
	
	
	function pages_() {
		layui.use('laypage', function(){
		    var laypage = layui.laypage;
		    //执行一个laypage实例
		    laypage.render({
		        elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
		        ,count: count //数据总数，从服务端得到
		        ,limit :3
		        ,groups :2
		        ,jump: function(obj, first){
		        	//意思为第一次不执行
		            if(!first){
		            	$('#carts').text('');
		        		str = "";
		        		get_orders((obj.curr-1)*3);
		            	
		            }
		        }
		    });
		});
	}
	
	
    function dd() {
        $(".order_del").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"确认删除 ID 为："+$(this).attr("rel")+" 的信息吗？",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/Shop-SSM/delByOrderId.do",
           	         type : "post",
           	         data:{
           	        	 "id" : ids,
           	         },
           	         dataType : "json",
           	         success : function (m) {
           	        	 if(m.state==1){
           	        		layer.msg("删除成功",{
           	                    icon:1,time:2000
           	                });
           	        		 setTimeout("location.href='user_center_order.html'",1000);
           	        	 }else{
           	        		 layer.msg('删除失败', {icon: 5,time: 800});
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
	
function pay_s() {
	$('#pay_').click(function() {
    	var ids = $(this).attr("rel");
        layer.open({
            icon:3,
            content:"确认付款吗？",
            title:"确认删除",
            btn: ['确定', '取消'],
            yes: function(index, layero){
        		$.ajax({
       			 url : "/Shop-SSM/pay_order.do",
       	         type : "post",
       	         data:{
       	        	 "id" : ids,
       	         },
       	         dataType : "json",
       	         success : function (m) {
       	        	 if(m.state==1){
       	        		layer.msg("付款成功",{
       	                    icon:1,time:2000
       	                });
       	        		 setTimeout("location.href='user_center_order.html'",1000);
       	        	 }else{
       	        		 layer.msg('付款', {icon: 5,time: 800});
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
	})
}	
	
	

	
});