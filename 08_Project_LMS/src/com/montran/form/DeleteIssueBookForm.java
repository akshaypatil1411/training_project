package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteIssueBookForm extends ActionForm{
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		
		if(request.getParameter("issue_serial_no") != null) {
			if(request.getParameter("issue_serial_no").equals("Delete") ) {
				if(getIssue_serial_no() == null || ("".equals(getIssue_serial_no())))
					errors.add("member.error", new ActionMessage("label.common.date"));
				
			}
		}
		return errors;
	}
	private String issue_serial_no;
	


	public String getIssue_serial_no() {
		return issue_serial_no;
	}

	public void setIssue_serial_no(String issue_serial_no) {
		this.issue_serial_no = issue_serial_no;
	}



	

	

}
