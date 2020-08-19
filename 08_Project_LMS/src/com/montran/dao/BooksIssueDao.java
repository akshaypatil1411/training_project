package com.montran.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.SizeOfPluralAttributeExpression;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

import com.montran.pojo.Book;
import com.montran.pojo.Issue;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class BooksIssueDao {

	private Session session;
	private Transaction transaction;
	private int issueSerialNumber;
	private SessionFactory factory = SessionFactoryUtil.getFactory();
	private Issue issue;

	public List<Issue> getAllIssuedBooks() {
		session = factory.openSession();
		Query query = session.createQuery("from issue_master order by issue_serial_no");
		List<Issue> issueList = query.list();
		// issueList.get(issue.getIssue_serial_no());
		return issueList;

	}
	
	public void updateBook(int issue_serial_no,Date issueDate,Date returnDate) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		Issue issue=session.get(Issue.class, issue_serial_no);
		issue.setDate_of_issue(issueDate);
		issue.setDate_of_return(returnDate);
		session.update(issue);
		transaction.commit();
		session.close();
	}
	
	public int maxSerialNo() {
		session = factory.openSession();
		
		Query query = session.createQuery("select max(issue_serial_no) from issue_master");
		List<Integer> serial_no = query.list();
		
		session.close();
		int maxNo = serial_no.get(0);
		System.out.println("serialno is ::"+serial_no);
		return maxNo+1;
	}

	public List<Issue> getMemberDetails() {
		session = factory.openSession();

		Query query = session.createQuery("from issue_master where member.member_code = :member_code");
		query.setParameter("member_code", query.getParameter("member_code"));
		List<Issue> issueList = query.list();
		// issueList.get(issue.getIssue_serial_no());
		return issueList;

	}

	public int issueNewBook(Issue details) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		issueSerialNumber = (int) session.save(details);
		transaction.commit();
		session.close();
		return issueSerialNumber;
	}

	public Book getBook(String bookCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Book book = session.get(Book.class, bookCode);
		session.close();
		return book;
	}

	public Member getMember(String memberCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Member member = session.get(Member.class, memberCode);
		session.close();
		return member; 
	}
	
	public int deleteIssueBook(int issue_serial_no) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		//Query query = session.createQuery("delete from issue_master where issue_serial_no = :code");
		//query.setParameter("code", issue_serial_no);
		//int result = query.executeUpdate();
		Issue issue = session.get(Issue.class, issue_serial_no);
		session.delete(issue);
		transaction.commit();
		session.close();
		return 1;
	}

}
