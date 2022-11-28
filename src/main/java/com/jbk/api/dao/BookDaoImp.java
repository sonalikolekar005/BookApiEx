package com.jbk.api.dao;

import java.util.List;

import javax.servlet.http.Cookie;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.api.entity.Book;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveBook(Book book) {

		Session session = sessionFactory.openSession();
		boolean isAdded = false;

		try {
			Book book1 = session.get(Book.class, book.getBookId());
			if (book1 == null) {
				Transaction transaction = session.beginTransaction();
				session.save(book);
				transaction.commit();
				isAdded = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List<Book> getAllBook() {
		Session session = sessionFactory.openSession();
		List<Book> list = null;
		try {

			Criteria criteria = session.createCriteria(Book.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Book getBookById(int booktId) {

		Session session = sessionFactory.openSession();
		Book book = null;
		try {
			book = session.get(Book.class, booktId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}

	@Override
	public boolean deletebook(int bookid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {

			Book book = session.get(Book.class, bookid);
			if (book != null) {

				session.delete(book);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Book book1 = session.get(Book.class, book.getBookId());
			session.evict(book1);
			if (book1 != null) {
				session.update(book);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public long getSumOfBook() {
		Session session = sessionFactory.openSession();
		double sum = 0;
		try {
			Criteria criteria = session.createCriteria(Book.class);
			criteria.setProjection(Projections.sum("bookPrise"));
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				sum = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return (long) sum;

	}

	@Override
	public List<Book> getMaxPriseOfBook() {
		Session session = sessionFactory.openSession();
		List<Book> maxBook = null;
		int maxPrise = 0;
		try {
			Criteria maxcriteria = session.createCriteria(Book.class);

			Criteria eqcriteria = session.createCriteria(Book.class);

			maxcriteria.setProjection(Projections.max("bookPrise"));
			List<Integer> list = maxcriteria.list();
			maxPrise = list.get(0);

			eqcriteria.add(Restrictions.eq("bookPrise", maxPrise));

			maxBook = eqcriteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return maxBook;

	}

	@Override
	public long getCountOfBook() {
		Session session = sessionFactory.openSession();
		long bookcount = 0;
		try {
			Criteria criteria = session.createCriteria(Book.class);

			criteria.setProjection(Projections.rowCount());

			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				bookcount = list.get(0);
			}

		} catch (Exception e) {

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return bookcount;
	}



	@Override
	public List<Book> getMinPriseOfBook() {
		Session session = sessionFactory.openSession();
		List<Book> minBook = null;
		int minPrise = 0;
		try {
			Criteria mincriteria = session.createCriteria(Book.class);

			Criteria eqcriteria = session.createCriteria(Book.class);

			mincriteria.setProjection(Projections.min("bookPrise"));
			List<Integer> list = mincriteria.list();
			minPrise = list.get(0);

			eqcriteria.add(Restrictions.eq("bookPrise", minPrise));

			minBook = eqcriteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return minBook;

	}

	@Override
	public List<Book> sortBookIdByDsc() {
		Session session = sessionFactory.openSession();
		List<Book> list = null;
		try {

			Criteria criteria = session.createCriteria(Book.class);
			criteria.addOrder(Order.desc("bookId"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Book> sortBookByIdAsc() {
		Session session = sessionFactory.openSession();
		List<Book> list = null;
		try {

			Criteria criteria = session.createCriteria(Book.class);

			criteria.addOrder(Order.asc("bookId"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Book> sortBookNameAsc() {
		Session session=sessionFactory.openSession();
		List<Book> list=null;
		try {
			Criteria criteria=session.createCriteria(Book.class);
			criteria.addOrder(Order.asc("bookName"));
			 list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		
		return list;
	}

	@Override
	public List<Book> sortBookNameDsc() {
		Session session=sessionFactory.openSession();
		List<Book> list=null;
		try {
			Criteria criteria=session.createCriteria(Book.class);
			criteria.addOrder(Order.desc("bookName"));
			 list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			{
				session.close();
			}
		}
		
		return list;
	}
}