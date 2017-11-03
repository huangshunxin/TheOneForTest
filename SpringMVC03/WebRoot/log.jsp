<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'log.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function login(){
	var param=$("#form1").serializeArray();
	$.post(
	"dologin",
	param,
	function(data){
		if(data=="ok"){
			location.href="index.jsp";
		}else{
			$("#span").html(data);
		}
	}
	)
}
</script>
  </head>
  
  <body>
  <span id="span"></span>
   <form id="form1" action="dolog">
   用户：<input type="text" name="username" value="${cookie.username.value }"><br>
  密码： <input type="text" name="pws" value="${cookie.pws.value }"><br>
  <input type="button" value="提交" onclick="login()">
 <input type="submit"   value="sub登陆"/>
   </form>
  </body>
</html>
