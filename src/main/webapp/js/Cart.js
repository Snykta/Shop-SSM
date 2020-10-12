/*$(function(){
	var carts = 1;
	$('#add_cart').click(function() {//加入购物车
		
		$.ajax({
			url : "/Shop-SSM/addCrat.do",
			type : "post",
			dataType : "json",
			data:{
				"goods_name":$('#goodname').html(),
				"goods_unit":$('#showun').html(),
				"goods_price":$('#show_peices').html(),
				"goods_num":$('#snum').val(),
				"users_id":eval("(" + $.cookie('shop-users') + ")")['id']
			},
			success : function(m) {
				if(m.state==1){
					layer.msg('加入成功', {icon: 1,time: 1300});
				}else{
					 layer.msg('加入失败', {icon: 5,time: 1000});
				}
			}
			
		});
	});*/
	
	
	
	/*$('#jia').click(function() {
		if($('#snum').val().trim()!=10){
			var aa = $('#snum').val().trim();
			$('#snum').val(Number(aa)+carts);
			var cc = $('#price').val();
			$('#counts').html(((Number($('#snum').val())*Number(cc))).toFixed(2)+"元")
		}else{
			alert("最多只能买十件")
		}
	})
	
	$('#jian').click(function() {
		if($('#snum').val().trim()!=1){
			var aa = $('#snum').val().trim();
			$('#snum').val(Number(aa)-carts);
			$('#counts').html((Number($('#snum').val())*Number($('#price').val())).toFixed(2)+"元")
			
		}
	})
	*/
	
	
	
	
//});
	
