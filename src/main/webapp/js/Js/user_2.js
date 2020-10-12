$(function() {
	var str = ""
	
	function getUsers() {
		$.ajax({
			url : "/Shop-SSM/adminOneByManyOrder.do",
			type : "get",
			dataType : "json",
			success : function(m) {
				UserList_(m)
				$('#users').append(str)
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
				str+="<td>"+arry[i]["lists"].length+"</td>"
				if(arry[i]["lists"].length==0){
					str+="<td><a style='color : #FF5722;cursor:default' href='Javascript:;'>无详情</a></td>"
				}else{
					str+="<td><a href='user_ordes_xi.html?id="+arry[i]["id"]+"'>查详情</a></td>"
				}
				str+="</tr>"
		}
		
	}


	
	
	
	
	
})