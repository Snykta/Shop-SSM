$(function() {
	var str ="";
	var pays=[];
	

		$.ajax({
		url : "/Shop-SSM/getIdGoods.do",
		type : "post",
		data : {
			"id" : GetQueryString("id")
		},
		dataType : "json",
		success : function(m) {
			console.log(m)
			getorder_(m);//拼接订单
			$('#goods_lists_end').append(str)//拼接后追加
			$('#zongjin').html($('#zon_').html() + "  元");//显示总价
		}

	});
		
		
		
		function ordersList_() {//将订单拼接，然后放入数组中，最后用来一起提交
			for (var i = 0; i < $('.uls').length; i++) {
				var $aa = $('.uls').eq(i);
						var dan={"order_userid":eval("(" + $.cookie('shop-users') + ")")['id'],
							"address":$('#dsd').html(),
							"pay_type" : $('input:radio[name="pay_style"]:checked').val(),
							"goods_name":$aa.find('li').eq(2).html(),
							"goods_num" : $aa.find('li').eq(5).html(),
							"goods_price" : $aa.find('li').eq(4).find('em').html(),
							"order_succ" : "1",
							"order_counts" : $aa.find('li').eq(6).find('a').html()
						}
						
						
						
						pays.push(dan);
			}
			
		}
		
		
	
	function getorder_(arry) {
	var	num = 1
			str+="<ul class='goods_list_td clearfix uls'>"
			str+="<li class='col01'>"+(num++)+"</li>"
			str+="<li class='col02'><img src='../images/goods02.jpg'></li>"
			str+="<li class='col03'>"+arry["goods_name"]+"</li>"
			str+="<li class='col04'>"+arry["goods_unit"]+"</li>"
			str+="<li class='col05'><em id='price_em'>"+arry["goods_price"]+"</em>元</li>"
			str+="<li class='col06'>"+GetQueryString("num")+"</li>"
			str+="<li class='col07'><a class='idsp' id='zon_'>"+(Number(arry["goods_price"])*Number(GetQueryString("num"))).toFixed(2)+"</a>元</li>"
			str+="</ul>"
	
	}
	
	
		$('#order_btn').click(function() {
			ordersList_()//订单数组集合
			$.ajax({
				url : "/Shop-SSM/paysDing.do",
				type : "post",
				data : {
					"lists" : JSON.stringify(pays)//将订单集合一起提交后台
				},
				dataType : "json",
				success : function(m) {
					if(m.state>0){
						alert("下单成功，请在订单中查看信息");
						location.href='index.html';
					}else{
						alert("下单失败!");
						location.href='cart.html';
					}
				}
			})
		});
})