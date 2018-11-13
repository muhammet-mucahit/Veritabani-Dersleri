<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Students</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Student Number</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Password</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.student_number}" /></td>
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.surname}" /></td>
            <td><c:out value="${student.password}" /></td>
            <td><a href="StudentController?action=edit&student_number=<c:out value="${student.student_number}"/>">Update</a></td>
            <td><a href="StudentController?action=delete&student_number=<c:out value="${student.student_number}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="StudentController?action=insert">Add User</a></p>
</body>
</html>