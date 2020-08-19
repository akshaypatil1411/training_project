<%@page import="com.montran.form.BooksIssuedForm"%>
<%@page import="com.montran.pojo.Issue"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Issue</title>
</head>
<body>
	<h3>Entry Form Contents</h3>


	<html:form action="newIssueAction" method="post">

		<table>
			<tr>
				<td>Issue serial Number</td>
				<!-- <td><input type="number" name="issue_serial_no"></td> -->
				 <td><html:text property="issue_serial_no" /></td> 
				<td></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<!-- <td><input type="text" name="member_code"></td> -->
				 <td><html:text property="member_code" /></td>
				<td><html:submit property="member" value="getMember">Get Member Details</html:submit></td> 
			</tr>
			<tr>
				<td>Member Name</td>
				<!-- <td><input type="text" name="member_name"></td> -->
				 				<td><html:text property="member_name" /></td> 
				<td></td>
			</tr>
			<tr>
				<td>Book Code</td>
				<!-- <td><input type="text" name="book_code"></td> -->
				 <td><html:text property="book_code" /></td>
				<td><html:submit value="getBook">Get Book Details</html:submit></td> 
			</tr>
			<tr>
				<td>Title</td>
				<!-- <td><input type="text" name="book_title"></td> -->
				 <td><html:text property="book_title" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Author</td>
				<!-- <td><input type="text" name="book_author"></td> -->
				 <td><html:text property="book_author" /></td> 
				<td></td>
			</tr>
			<tr>
				<td>Issue Date</td>
				<!-- <td><input type="date" name="date_of_issue"></td> -->
				 <td><html:text property="book_author" /></td> 
				<td></td>
			</tr>
			<tr>
				<td>Return Date</td>
				<!-- <td><input type="date" name="date_of_return"></td> -->
				 <td><html:text property="book_author" /></td> 
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Add Issue</html:submit></td>
			</tr>
		</table>
	</html:form>




</body>
</html>





