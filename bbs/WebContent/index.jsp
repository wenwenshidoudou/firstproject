<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
String un =(String)session.getAttribute("un");
String pw =(String)session.getAttribute("pw");
if(un!=null  && !"".equals(un)  && pw!=null && !"".equals(pw)){

	
}else{
	response.sendRedirect("login.jsp");

}



%>
<link rel="stylesheet" href="css/stylemain.css" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<div class="shell">

			<!-- 顶部 -->
			<div id="top">
				<h1>BBS论坛</h1>
				<div id="top-navigation">
					欢迎 <a href="#"><strong>${sessionScope.un} </strong></a> <span>|</span> 
					<a href="UserServlet?sign=logout">退出</a>
				</div>
			</div>


			<!-- 导航 -->
			<div id="navigation">
				<ul>
					<li><a href="UserServlet?sign=userList" class="active"><span>用户管理</span></a></li>

					<li><a href="#"><span>论坛</span></a></li>
					<li><a href="#"><span>帮助</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- End Header -->

	<!-- Footer -->
	<div id="footer">
		<div class="shell">
			<span class="left">&copy; 2014</span> <span class="right"> 版本 2014V1.0 </span>
		</div>
	</div>
</body>

</body>
</html>