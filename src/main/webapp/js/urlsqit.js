function GetQueryString(name) {
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
var r = window.location.search.substr(1).match(reg);
var context = "";
if (r != null)
context = r[2];
reg = null;
r = null;
return context == null || context == "" || context == "undefined" ? "" :decodeURI(context);
}
/**
 * 截取url
 * 比如baidu.com?name=123
 * 获取？后面name的值
 * 就可以这样写
 * GetQueryString(name)
 */