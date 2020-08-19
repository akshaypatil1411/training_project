package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksIssueDao;
import com.montran.pojo.Issue;

public class BooksIssuedListAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("In action execute");
		//BooksIssuedForm form2 = (BooksIssuedForm)form;
	
		BooksIssueDao dao = new BooksIssueDao();
		List<Issue> issueList = dao.getAllIssuedBooks();
		request.setAttribute("issued", issueList);

		return mapping.findForward("success");
	}
}
