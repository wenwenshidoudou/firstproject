<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" href="css/stylemain.css" type="text/css" media="all" />
<script type="text/javascript">

</script>
<script type="text/javascript">
	function check(){
		var un=document.getElementById("un").value;//进行非空验证；
		var pw=document.getElementById("pw").value;
		if(un !="" && pw !="" ){
			return true;
		}else{
			alert("请输入用户名和密码");
			return false;
		}
	}

</script>

</head>
<body>
<a href=http://localhost:8080/bbs/UserServlet>超链接</a>
	<form action="UserServlet?sign=login" method="post" onsubmit="return check()" >
		<table border="0" cellpadding="0" cellspacing="0" align="center">
		<!-- 上 -->
			<tr>
			<td  background="images/login_04.gif" width="862px" height="266px"></td>
			</tr>
		<!-- 中 -->
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td background="images/login_06.gif" width="424px" height="95px"></td>
						<td background="images/login_07.gif" width="183px" height="95px">
							<table>
								<tr height="30px">
									<td class="word">用户</td>
									<td><input type="text" id="un"name="un" style="width:130px"/>
								</tr>
								<tr height="30px">
									<td class="word">密码</td>
									<td><input type="password" id="pw"name="pw" style="width:130px"/>
								</tr>
								<tr>
									<td colspan="2" style="text-align:center">
										<input type="submit" id="submit" name="un" value="登陆" />
										
										<input type="reset" id="reset" name="pw" value="重置"/>
									</td>
								</tr>
							</table>
						</td>
						<td background="images/login_08.gif" width="255px" height="95px"></td>
					</tr>
					</table>
				
				</td>
			</tr>
		<!-- 下 -->
			<tr>
			<td height="247" width="862px" background="images/login_09.gif"></td>			
			</tr>
		</table>
		
	</form>

</body>
</html>