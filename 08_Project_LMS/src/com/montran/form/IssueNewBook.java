package com.montran.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IssueNewBook extends ActionForm {

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("verifyMember") != null) {
			if (request.getParameter("verifyMember").equals("getMember")) {
				if (getMemberCode() == null || ("".equals(getMemberCode()))) {
					errors.add("member.error", new ActionMessage("label.common.memberCode"));
				}
//				if (request.getAttribute("member") == null) {
//					errors.add("member.error", new ActionMessage("label.common.member"));
//				}

			}

		}

		if (request.getParameter("verifyBook") != null) {
			if (request.getParameter("verifyBook").equals("getBook")) {
				if (getBookCode() == null || ("".equals(getBookCode()))) {
					errors.add("book.error", new ActionMessage("label.common.bookCode"));
				}

			}

		}

		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				if (getMemberCode() == null || ("".equals(getMemberCode()))) {
					errors.add("member.error", new ActionMessage("label.common.memberCode"));
				}
				if (getBookCode() == null || ("".equals(getBookCode()))) {
					errors.add("book.error", new ActionMessage("label.common.bookCode"));
				}
			}
		}

		if (request.getParameter("issueDate") != null) {
			if (request.getParameter("issueDate").equals("issueDate")) {
				if (getIssueDate() == null) {
					errors.add("date.error", new ActionMessage("label.common.date"));
				}
			}
		}
		if (request.getParameter("returnDate") != null) {
			if (request.getParameter("returnDate").equals("returnDate")) {
				if (getIssueDate() == null) {
					errors.add("date.error", new ActionMessage("label.common.date"));
				}
			}
		}
		return errors;
	}

	private int serialNo;
	private String memberCode;
	private String bookCode;
	private String memberName;
	private String bookTitle;
	private String bookAuthor;
	private String issueDate;
	private String returnDate;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "IssueNewBook [serialNo=" + serialNo + ", memberCode=" + memberCode + ", bookCode=" + bookCode
				+ ", memberName=" + memberName + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}

}