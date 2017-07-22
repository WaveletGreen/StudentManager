package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.BaseDao;
import util.Page;

@Repository
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory HibernateSession;
	private String hql;// hql语句

	/************** 获取和当前线程绑定的Seesion ****************/
	private Session getSession() {
		return HibernateSession.getCurrentSession();
	}

	@Override
	public <T> String add(T t) {
		try {
			Transaction tx = getSession().beginTransaction();
			Session session = getSession();
			session.save(t);
			tx.commit();
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return "error:" + e.getStackTrace();
		}
	}

	@Override
	public <T> String delet(T t) {
		if (t != null) {
			try {
				Transaction tx = getSession().beginTransaction();
				Session session = getSession();
				session.delete(t);
				tx.commit();
				return "success";
			} catch (HibernateException e) {
				e.printStackTrace();
				return "error:" + e.getStackTrace();
			}
		}
		return "error";

	}

	@Override
	public <T> String update(T t) {
		if (t != null) {
			try {
				Transaction tx = getSession().beginTransaction();
				Session session = getSession();
				session.update(t);
				tx.commit();
				return "success";
			} catch (HibernateException e) {
				e.printStackTrace();
				return "error:" + e.getStackTrace();
			}
		}
		return "error";
	}

	@Override
	public <T> T getById(T t, int id) {
		if (t != null) {

			hql = "from " + t.toString() + " where 1=1 and Sid=:id";
			try {
				Session session = getSession();
				Query query = session.createQuery(hql);
				query.setInteger("id", id);
				T result = (T) query.uniqueResult();
				return result;
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;

	}

	@Override
	public <T> List<T> getByPage(T t, Page page) {
		String hql = "from " + t.toString();
		Query query = getSession().createQuery(hql);
		// page.getStart从0开始计数，因此传进来的时候需要根据要求-1
		query.setFirstResult((page.getStart()) * page.getMaxResult());
		query.setMaxResults(page.getMaxResult());
		List<T> items = query.list();
		return items;
	}
}
