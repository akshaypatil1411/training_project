package com.montran.form;

import java.time.LocalDate;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.montran.pojo.Book;
import com.montran.pojo.Member;

public class BooksIssuedForm extends ActionForm {
	private int issue_serial_no;
	private LocalDate date_of_issue;
	private Date date_of_return;
	private Book book;
	private Member member;

	public int getIssue_serial_no() {
		return issue_serial_no;
	}

	public void setIssue_serial_no(int issue_serial_no) {
		this.issue_serial_no = issue_serial_no;
	}

	public LocalDate getDate_of_issue() {
		return date_of_issue;
	}

	public void setDate_of_issue(LocalDate date_of_issue) {
		this.date_of_issue = date_of_issue;
	}

	public Date getDate_of_return() {
		return date_of_return;
	}

	public void setDate_of_return(Date date_of_return) {
		this.date_of_return = date_of_return;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
