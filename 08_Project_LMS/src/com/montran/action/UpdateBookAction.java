package com.montran.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksIssueDao;
import com.montran.form.IssueNewBook;
import com.montran.pojo.Issue;

public class UpdateBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IssueNewBook updateForm = (IssueNewBook) form;
		BooksIssueDao dao = new BooksIssueDao();
		Issue issue = new Issue();
		if(Date.valueOf(updateForm.getIssueDate()).before(Date.valueOf(updateForm.getReturnDate())) ) {
		dao.updateBook(updateForm.getSerialNo(), Date.valueOf(updateForm.getIssueDate()),Date.valueOf(updateForm.getReturnDate()));

		return mapping.findForward("success");
		}
		else {
			return mapping.findForward("failure");
		}
	}
	
	
}