package com.Dibike.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {

	// private Class<T> clazz;
	//
	// /**
	// * ͨ���췽��ָ��DAO�ľ���ʵ����
	// */
	// public BaseDaoImpl() {
	// ParameterizedType type = (ParameterizedType)
	// this.getClass().getGenericSuperclass();
	// clazz = (Class<T>) type.getActualTypeArguments()[0];
	// System.out.println("DAO����ʵʵ�����ǣ�" + this.clazz.getName());
	// }

	/**
	 * ��DAO��ע��SessionFactory
	 */
	
	
	
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	//
	public void save(T o) {
		Session session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();
	}

	public void delete(T o) {
		Session session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(o);
		tx.commit();
	}

	public void update(T o) {
		Session session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(o);
		tx.commit();
	}

	public void saveOrUpdate(T o) {
		Session session = this.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(o);
		tx.commit();
	}

	public List<T> find(String hql) {
		this.getCurrentSession().beginTransaction();
		List lists=this.getCurrentSession().createQuery(hql).list();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return lists;
	}

	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	public List<T> find(String hql, List<Object> param) {
		this.getCurrentSession().beginTransaction();
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		List list=q.list();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return list;
	}

	// public List<T> find(String hql, Object[] param, Integer page, Integer
	// rows) {
	// if (page == null || page < 1) {
	// page = 1;
	// }
	// if (rows == null || rows < 1) {
	// rows = 10;
	// }
	// Query q = this.getCurrentSession().createQuery(hql);
	// if (param != null && param.length > 0) {
	// for (int i = 0; i < param.length; i++) {
	// q.setParameter(i, param[i]);
	// }
	// }
	// return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	// }

	public List<T> find(String hql, Integer page, Integer rows) {
		this.getCurrentSession().beginTransaction();
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> list=q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return list;
	}

	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		this.getCurrentSession().beginTransaction();
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		List<T> list=q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return list;
	}

	public T get(Class<T> c, Serializable id) {
		this.getCurrentSession().beginTransaction();
		T t=(T) this.getCurrentSession().get(c, id);
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return t;
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
		this.getCurrentSession().beginTransaction();
		long lon=(Long) this.getCurrentSession().createQuery(hql).uniqueResult();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return lon;
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Integer executeHql(String hql) {
		this.getCurrentSession().beginTransaction();
		Integer lon=this.getCurrentSession().createQuery(hql).executeUpdate();
		this.getCurrentSession().getTransaction().commit();
		this.getCurrentSession().close();
		return lon;
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}


	@Override
	public void delete(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		q.executeUpdate();
	}

	@Override
	public void into(String hql, String param) {
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter(0, param);
		q.executeUpdate();
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria,
			int pageNum, int pageSize) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(this
				.getCurrentSession());
		criteria.setFirstResult((pageNum - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		List<T> list = null;
		Criteria criteria = detachedCriteria.getExecutableCriteria(this
				.getCurrentSession());
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		list = criteria.list();
		return list;
	}
}
