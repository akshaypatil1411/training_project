package com.montran.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "issue_master")
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issue_serial_no;
	private Date date_of_issue;
	private Date date_of_return;
	@OneToOne
	@JoinColumn(name = "book_code")
	private Book book;
	@JoinColumn(name = "member_code")
	@OneToOne
	private Member member;

	public Issue() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Issue(int issue_serial_no, Date date_of_issue, Date date_of_return, Book book, Member member) {
		super();
		this.issue_serial_no = issue_serial_no;
		this.date_of_issue = date_of_issue;
		this.date_of_return = date_of_return;
		this.book = book;
		this.member = member;
	}

	public int getIssue_serial_no() {
		return issue_serial_no;
	}

	public void setIssue_serial_no(int issue_serial_no) {
		this.issue_serial_no = issue_serial_no;
	}

	public Date getDate_of_issue() {
		return date_of_issue;
	}

	public void setDate_of_issue(Date date_of_issue) {
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

	@Override
	public String toString() {
		return "Issue [issue_serial_no=" + issue_serial_no + ", date_of_issue=" + date_of_issue + ", date_of_return="
				+ date_of_return + ", book=" + book + ", member=" + member + "]";
	}



		
	
	
}
