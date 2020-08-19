package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksIssueDao;
import com.montran.form.DeleteIssueBookForm;

public class DeleteIssueBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DeleteIssueBookForm form2 = (DeleteIssueBookForm) form;
		BooksIssueDao dao = new BooksIssueDao();
		dao.deleteIssueBook(Integer.parseInt(form2.getIssue_serial_no()));
		System.out.println("Book Deleted Successfully");
		
		

		return mapping.findForward("success");
		
	}

}
