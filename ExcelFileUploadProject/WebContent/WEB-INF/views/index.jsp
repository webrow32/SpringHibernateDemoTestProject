<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:form method = "post" commandName="excelfile" action = "importexcel" enctype = "multipart/form-data"	>
		Please select excel file <input type = "file" name = "file">
		<br/>
		<input type = "submit" value = "Upload">
	</c:form>	
</body>
</html>