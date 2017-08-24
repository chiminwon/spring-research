<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>测试SpringMVC中上传的实现</title>
	</head>
	
	<body>
		<form action="upload.do"  method="post" enctype="multipart/form-data">
			<input type="text" name="name" />
			<input type="file" name="file" />
			<input type="submit" />
		</form>
	</body>
</html>
