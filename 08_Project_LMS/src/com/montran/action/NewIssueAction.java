package com.montran.action;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksIssueDao;
import com.montran.form.BooksIssuedForm;
import com.montran.pojo.Issue;

public class NewIssueAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("In new issue execute");
		
		  BooksIssueDao dao = new BooksIssueDao();
		  
		  System.out.println("in execute :: IssueNewBookAction"); Enumeration<String>
		  param = request.getParameterNames();
		  
		  while (param.hasMoreElements()) { System.out.println(""); String temp =
		  (String) param.nextElement();
		  
		  System.out.println(request.getParameter(temp)); }
		  System.out.println("in execute"); if (request.getParameter("getMember") !=
		  null) { System.out.println(request.getParameter("getMember")); }
		  BooksIssuedForm issueDetailsForm = (BooksIssuedForm) form;
		  
		 Issue details = new Issue();
		  issueDetailsForm.setIssue_serial_no(dao.issueNewBook(details));
		 

//		 BooksIssuedForm booksIssuedForm = (BooksIssuedForm)form;
//		
//			
//
//			
//			Issue issue = new Issue();
//			issue.setIssue_serial_no(booksIssuedForm.getIssue_serial_no());
//			issue.setDate_of_issue(booksIssuedForm.getDate_of_issue());
//			issue.setDate_of_return(booksIssuedForm.getDate_of_return());
//			issue.setMember(booksIssuedForm.getMember());
//			issue.setBook(booksIssuedForm.getBook());
//			System.out.println(issue);
//			
//			
//		
//			BooksIssueDao dao = new BooksIssueDao();
//			dao.issueNewBook(issue);
//			System.out.println("Book added in table");

		return mapping.findForward("success");
	}
}
