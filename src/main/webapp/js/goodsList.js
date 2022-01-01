$(function() {
var rod = "";
	$.ajax({
		url : "/Shop-SSM/roundGoods.do",
		type : "get",
		dataType : "json",
		success : function (m) {
			suiji(m)
			$('#suiji').append(rod)
		}
		
	})

	function suiji(arry) {
		for(var i in arry){
			rod+="<li>"
			rod+="<a href='detail.html?id="+arry[i]["id"]+"'><img src='../images/"+arry[i]["goods_img"]+"'></a>"
			rod+="<h4><a href='detail.html?id="+arry[i]["id"]+"'>"+arry[i]["goods_name"]+"</a></h4>"
			rod+="<div class='prize'>￥"+arry[i]["goods_price"]+"</div></li>"
		}
	}
	
})