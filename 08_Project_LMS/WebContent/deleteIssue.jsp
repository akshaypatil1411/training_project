<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Issue Book</title>
</head>
<body>
	<h3>Delete Issue Book</h3>
	<hr>
	<html:form action="deleteIssueBook" method="post">

		Enter Serial number to delete the issued book
		<html:text property="issue_serial_no" />
		
		<br>
		<html:submit property="issue_serial_no" value="Delete">Delete Issue Book</html:submit>
	</html:form>
	<div style="color: red">
	<html:errors/>
</body>
</html>