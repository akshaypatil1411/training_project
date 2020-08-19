package com.montran.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "member_master")
public class Member {

	@Id
	private String member_code;
	private String member_type;
	private String member_name;
	private int no_of_books_issued;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String member_code, String member_type, String member_name, int no_of_books_issued) {
		super();
		this.member_code = member_code;
		this.member_type = member_type;
		this.member_name = member_name;
		this.no_of_books_issued = no_of_books_issued;
	}

	public String getMember_code() {
		return member_code;
	}

	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}

	public String getMember_type() {
		return member_type;
	}

	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getNo_of_books_issued() {
		return no_of_books_issued;
	}

	public void setNo_of_books_issued(int no_of_books_issued) {
		this.no_of_books_issued = no_of_books_issued;
	}

	@Override
	public String toString() {
		return "Member [member_code=" + member_code + ", member_type=" + member_type + ", member_name=" + member_name
				+ ", no_of_books_issued=" + no_of_books_issued + "]";
	}
	
	
}
