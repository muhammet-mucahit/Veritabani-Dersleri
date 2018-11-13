<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Add new student</title>
</head>
<body>

<form method="POST" action='StudentController' name="formAddStudent">
    Student Number : <input type="text" name="student_number" value="<c:out value="${student.student_number}" />" />
    <br/>
    Name : <input type="text" name="name" value="<c:out value="${student.name}" />" />
    <br/>
    Surname : <input type="text" name="surname" value="<c:out value="${student.surname}" />" />
    <br/>
    Password : <input type="text" name="password" value="<c:out value="${student.password}" />" />
    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>