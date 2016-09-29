package com.nagarro.javatraining.assignment9.HB;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.javatraining.assignment9.HB.HibernateUtil;
import com.nagarro.javatraining.assignment9.Dao.HrDao;
import com.nagarro.javatraining.assignment9.modelObjects.Hr;

public class HrDBAcessService implements HrDao {

	@Override
	public boolean addHrUser(Hr hrEmp) {
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		try {
			session.save(hrEmp);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close() ;
			return false ;
		}
		session.close() ;
		return true ;
	}

	@Override
	public Hr getHrUser(String userid) {
		
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Hr where userId=:userid");
		query.setParameter("userid", userid);
		Hr hr = null ;
		try {
			hr = (Hr)query.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close() ;
		}
		session.close();
		return hr ;
	}

}
