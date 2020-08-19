<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Issued Books</title>
</head>
<body>

	<h3>List of Issued Books</h3>
	<hr>
	<form action="booksIssuedListAction" method="post">
		<table border="1">
			<tr>
				<th>Issue Serial Number</th>
				<th>Member Code</th>
				<th>Member Name</th>
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Date of Issue</th>
				<th>Date of Return</th>

			</tr>

			<logic:iterate name="issued" id="allBooksIssued">
				<tr>
					<td><bean:write name="allBooksIssued"
							property="issue_serial_no" /></td>
					<td><bean:write name="allBooksIssued" property="member.member_code" /></td>
					<td><bean:write name="allBooksIssued" property="member.member_name" /></td>
					<td><bean:write name="allBooksIssued" property="book.book_code" /></td>
					<td><bean:write name="allBooksIssued" property="book.book_title" /></td>
					<td><bean:write name="allBooksIssued" property="date_of_issue" /></td>
					<td><bean:write name="allBooksIssued"
							property="date_of_return" /></td>
				</tr>
			</logic:iterate>

		</table>
		<hr>
		<br><br>
		
		 <a href="new.jsp" >New</a> 
 	<%-- <html:link action="new.jsp">Issue New Book</html:link> --%> 
	
		<a href="updateIssue.jsp">Update</a>
		<a href="deleteIssue.jsp">Delete</a>
		
	</form>

</body>
</html>