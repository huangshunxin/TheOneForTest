<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>editl.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function edit(){
$.post(
	"getedit",
	null,
	function(data){
	var str="商品名"+data.name+" 价格"+data.price;
	$("#mydiv").html(str);
	},
	"json"
)
$(document).ready(function(){
edit();
})
}
</script>
  </head>
  
  <body onload="edit()">
    <div id="mydiv"></div>
  </body>
  
</html>
