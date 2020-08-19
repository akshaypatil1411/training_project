package com.montran.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book_master")
public class Book {

	@Id
	private String book_code;
	private String book_title;
	private String book_author;
	private boolean is_issued;
	private boolean is_issuable;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String book_code, String book_title, String book_author, boolean is_issued, boolean is_issuable) {
		super();
		this.book_code = book_code;
		this.book_title = book_title;
		this.book_author = book_author;
		this.is_issued = is_issued;
		this.is_issuable = is_issuable;
	}

	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public boolean isIs_issued() {
		return is_issued;
	}

	public void setIs_issued(boolean is_issued) {
		this.is_issued = is_issued;
	}

	public boolean isIs_issuable() {
		return is_issuable;
	}

	public void setIs_issuable(boolean is_issuable) {
		this.is_issuable = is_issuable;
	}

	@Override
	public String toString() {
		return "Book [book_code=" + book_code + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", is_issued=" + is_issued + ", is_issuable=" + is_issuable + "]";
	}
	
	
}
