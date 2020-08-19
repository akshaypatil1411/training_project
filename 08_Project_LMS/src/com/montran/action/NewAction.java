package com.montran.action;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksIssueDao;
import com.montran.form.IssueNewBook;
import com.montran.pojo.Book;
import com.montran.pojo.Issue;
import com.montran.pojo.Member;

public class NewAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

//		long millis = System.currentTimeMillis();
//		Date date = new Date(millis);		
		BooksIssueDao dao = new BooksIssueDao();
		Book book = null;
		Member member = null;
		// List serial_no;
		book = new Book();
		Issue issue = new Issue();
		IssueNewBook form2 = (IssueNewBook) form;

		// serial_no = dao.maxSerialNo();
		if(request.getParameter("getserialno") != null) {
			if(request.getParameter("getserialno").equals("Generate next serial number")) {
		form2.setSerialNo(dao.maxSerialNo());
			}
			return mapping.findForward("serialno");
		}

		// request.setAttribute("serial_no", serial_no.get(0));
		// System.out.println("Serial no in action is :: "+serial_no);

		if (request.getParameter("verifyMember") != null) {
			if (request.getParameter("verifyMember").equals("getMember")) {
				System.out.println("Get Member button");
				System.out.println(form2.getMemberCode());
				member = dao.getMember(form2.getMemberCode());
				form2.setMemberName(member.getMember_name());
				return mapping.findForward("book");
			}
		}

		if (request.getParameter("verifyBook") != null) {
			if (request.getParameter("verifyBook").equals("getBook")) {
				System.out.println("getBook Button Clicked");
				System.out.println(form2.getBookCode());
				book = dao.getBook(form2.getBookCode());
				form2.setBookAuthor((book.getBook_author()));
				form2.setBookTitle((book.getBook_title()));

				LocalDate issueDate = LocalDate.now();
				LocalDate returnDate = LocalDate.now();

				member = dao.getMember(form2.getMemberCode());
				form2.setMemberName(member.getMember_name());
				member.setNo_of_books_issued(member.getNo_of_books_issued()+1);

				if (member.getMember_type().equals("student")) {
					returnDate = returnDate.plusDays(8);
					System.out.println(form2);
				}
				if (member.getMember_type().equals("faculty")) {
					returnDate = returnDate.plusDays(90);
					System.out.println(form2);
				}

				form2.setIssueDate(issueDate.toString());
				form2.setReturnDate(returnDate.toString());
				System.out.println("--------------------------------------");
				System.out.println(form2);

				HttpSession httpSession = request.getSession();

				httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("returnDate", returnDate);
				return mapping.findForward("member");
			}
		}

		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("Issue Book Button Click");
				HttpSession httpSession = request.getSession();
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book = (Book) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					member = (Member) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");

			
				java.util.Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				java.util.Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				if((member.getMember_type().equals("student") && member.getNo_of_books_issued()<=3) || (member.getMember_type().equals("faculty") && member.getNo_of_books_issued()<=25)){
				
				issue = new Issue(form2.getSerialNo(), issueD, returnD, book, member);
				dao.issueNewBook(issue);
				System.out.println("Book Issued Successfully !!");
				}
				else {
					System.out.println("Failed to issue Book");
				}
			}
		}

		return mapping.findForward("success");

	}
}









//		if (form2.getBookCode() != null) {
//			System.out.println("in book");
//			//book = dao.getBook((form2.getBookCode()));
//			book = dao.getBook(form2.getBookCode());
//			request.setAttribute("bookTitle", book.getBook_title());
//			request.setAttribute("bookAuthor", book.getBook_author());
//			System.out.println("booktitle in action :"+book.getBook_title());
//			// request.setAttribute("book", book);
//		}
//		else if (form2.getBookCode() == null) {
//			book = null;
//			request.setAttribute("book", book);
//		}
//		
//		// BooksIssuedForm form2 = (BooksIssuedForm)form;
//		if (form2.getMemberCode() != null) {
//			System.out.println("In if member");
//			member = dao.getMember((form2.getMemberCode()));
//			request.setAttribute("member", member.getMember_name());
//			
//			// request.setAttribute("member", member);
//		} 
//
//		LocalDate date1 = LocalDate.now();
//		Date dat = Date.valueOf(date1);
//		request.setAttribute("Date", date);
//
//		Issue issue2=new Issue(Integer.parseInt(serial_no.get(0).toString()),date,date,book,member);
//		dao.issueNewBook(issue2);
//		String issueStatus="Book issued successfully";
//		request.setAttribute("issueStatus", issueStatus);
//		System.out.println("Book added in table");
//		return mapping.findForward("success");
//	}
