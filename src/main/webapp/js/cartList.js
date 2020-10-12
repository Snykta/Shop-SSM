$(function() {
	var str ="";
	var cc = 0;
	$.ajax({
		url : "/Shop-SSM/getUserIdC.do",
		type : "post",
		data :{
			"id" : eval("(" + $.cookie('shop-users') + ")")['id']
		},
	dataType : "json",
	success : function(m) {
		console.log(m)
		$('#ems').html(m.length)
		$('#countB').html(m.length)
		lists(m);
		$('#cart_lists').append(str)
		$(".idsp").each(function (index,domEle){
			cc = cc+Number($(this).text());
		  })
		  $('#count_prices').html(cc)
		  dd();
	}
		
	})
	
	
	function lists(arry) {
		for(var i in arry){
		str+="<ul class='cart_list_td clearfix'>"
		str+="<li class='col01'><input type='checkbox' value='"+arry[i]["id"]+"'></li>"
		str+="<li class='col02'><img src='../images/goods003.jpg'></li>"
		str+="<li class='col03'>"+arry[i]["goods_name"]+"<br><em>"+arry[i]["goods_price"]+"/"+arry[i]["goods_unit"]+"</em></li>"
		str+="<li class='col04'>"+arry[i]["goods_unit"]+"</li>"
		str+="<li class='col05'>"+arry[i]["goods_price"]+"元</li>"
		str+="<li class='col06'>"+arry[i]["goods_num"]+"</li>"
		str+="<li class='col07'><a class='idsp'>"+((Number(arry[i]["goods_price"]))*(Number(arry[i]["goods_num"]))).toFixed(2)+"</a>元</li>"
		str+="<li class='col08 '><a class='cart_del' href='javascript:;'  rel='"+arry[i]["id"]+"'  style='color:red'>删除</a></li>"
		str+="</ul>"
		}
	}
	
	
    function dd() {
        $(".cart_del").click(function(){
        	var ids = $(this).attr("rel");
            layer.open({
                icon:3,
                content:"确认删除 ID 为："+$(this).attr("rel")+" 的信息吗？",
                title:"确认删除",
                btn: ['确定', '取消'],
                yes: function(index, layero){
            		$.ajax({
           			 url : "/Shop-SSM/delByid.do",
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
           	        		 setTimeout("location.href='cart.html'",1000);
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
    
    
    
    
    
    $('#btn_check').click(function() {//全选/反选
    	var $listc = $('#cart_lists input:checkbox');
    	$listc.each(function (index, element) {
    		if($('#btn_check').prop('checked')){
    			$listc.get(index).checked=true;
        	}else{
        		$listc.get(index).checked=false;
        	}
		});
	});
    
    
    
    var num =0;
    $('#btn').click(function() {
    	var arr = "";
		var $listc = $('#cart_lists input:checkbox');
		$listc.each(function (index, element) {
	           if($listc.get(index).checked){
	        	   num++;
	        	  arr+=$(this).val()+",";//拼接值
	           }
	        });
		
		if(num==0){
			layer.msg('请先选中数据', {icon: 5,time: 800});
			 return false;
		}else{
		    layer.open({
	            icon:3,
	            content:"确认删除该"+num+"条信息吗？",
	            title:"确认删除",
	            btn: ['确定', '取消'],
	            yes: function(index, layero){
	        		$.ajax({
	       			 url : "/Shop-SSM/delByIdsA.do",
	       	         type : "post",
	       	         data:{
	       	        	 "ids" : arr
	       	         },
	       	         dataType : "json",
	       	         success : function (m) {
	      	        	 if(m.state==1){
	       	        		layer.msg("删除成功",{
	       	                    icon:1,time:2000
	       	                });
	       	        		 setTimeout("location.href='cart.html'",1000);
	       	        	 }else{
	       	        		 layer.msg('删除失败', {icon: 5,time: 800});
	       	        	 }
	       	         } 
	       		});
	                
	            }
	            ,btn2: function(index, layero){
	            	num = 0;
	            	arr = "";
	                layer.msg("已取消",{
	                    icon:2,time:1000
	                });
	            }
	        });
		}
	})
	
})


