<%@page import="com.montran.action.NewAction"%>
<%@page import="com.montran.pojo.Issue"%>
<%@page import="com.montran.form.IssueNewBook"%>
<%@page import="java.sql.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Books</title>
</head>
<body>



	<h3>Book Issue Details</h3>
	<hr>
	<%-- <%
		/* if (request.getAttribute("serial_no") != null) {
		serial_no = request.getAttribute("serial_no").toString();
		/* System.out.println("Serial no in new is :: " + serial_no); */
	} */
	%> --%>

	<html:form action="newAction" method="post">
		<table>
			<tr>
				<td><html:submit property="getserialno" value="Generate next serial number">Generate next serial number</html:submit></td>
			</tr>
			<tr>

				<td>Issue Serial No</td>


				<td><html:text property="serialNo" /></td>

			</tr>

			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="verifyMember" value="getMember">Verify member</html:submit></td>
			</tr>
			<tr>
				<td>Name</td>

				<%-- 	<%
					/* if (request.getAttribute("member") != null) {
					member = request.getAttribute("member").toString();
				} else if (request.getAttribute("member") == null) {
					member = "No members found";
				} */
				%> --%>
				<%-- <td><%=member%></td> --%>
				<td><html:text property="memberName" /></td>
			</tr>

			<tr>
				<td>Book code</td>
				<td><html:text property="bookCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="verifyBook" value="getBook">Verify book code</html:submit></td>
			</tr>
			<tr>
				<td>Title</td>
				<%-- <%
					/*  if (request.getAttribute("bookTitle") != null && request.getAttribute("bookAuthor") != null) {
					System.out.println("in new book");
					bookTitle = request.getAttribute("bookTitle").toString();
					bookAuthor = request.getAttribute("bookAuthor").toString();
					System.out.println(bookTitle);
					System.out.println(bookAuthor);
				}
				else if (request.getAttribute("bookTitle") == null ||  request.getAttribute("bookAuthor") == null) {
					bookTitle = "No books found";
					bookAuthor = "No books found";
				} */
				%> --%>
				<%-- <td><%=bookTitle%></td> --%>
				<td><html:text property="bookTitle" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<%-- 	<td><%=bookAuthor%></td> --%>
				<td><html:text property="bookAuthor" /></td>
			</tr>
			<tr>
				<td>Date of Issue</td>
				<%-- 	<td><%=date%></td> --%>
				<td><html:text property="issueDate" /></td>
			</tr>
			<tr>
				<td>Due Date</td>
				<%-- <td><%=date%></td> --%>
				<td><html:text property="returnDate" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit property="issue" value="issueBook">Issue Book</html:submit></td>

			</tr>
			<tr>
				<td>
					<%-- <%
						if (request.getAttribute("issueStatus") != null) {
						issueStatus = request.getAttribute("issueStatus").toString();
					} else if (request.getAttribute("issueStatus") == null) {
						issueStatus = "failed";
					}
					%> <%=issueStatus%> --%>
				</td>
			</tr>
		</table>
	</html:form>
	
	<div style="color: red">
	<html:errors/>
</body>
</html>