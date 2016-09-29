package com.nagarro.javatraining.assignment9.HB;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.nagarro.javatraining.assignment9.Dao.EmployeeDao;
import com.nagarro.javatraining.assignment9.modelObjects.Employee;

public class EmployeeDBAcessService implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee"); 
		List<Employee> li= null ;
		try {
			li = (List<Employee>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close() ;
			return null ;
		}
		session.close();
		return li; 
	}

	@Override
	public boolean updateEmployee(Employee newDetails) {
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		Employee oldEmployee = (Employee) session.get(Employee.class, newDetails.getEmployeeCode());
		if(oldEmployee==null)
			return false ;
		oldEmployee.setEmail(newDetails.getEmail());
		oldEmployee.setDob(newDetails.getDob());
		oldEmployee.setLocation(newDetails.getLocation());
		oldEmployee.setName(newDetails.getName());
		try {
			session.update(oldEmployee);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return false ;
		}
		session.close();
		return true ;
	}

//	@Override
//	public boolean deleteEmployee(int empCode) {
//		Session session = HibernateUtil.sf.openSession();
//		session.beginTransaction();
//		try {
//			Employee employee = (Employee) session.get(Employee.class, empCode);
//			session.delete(employee);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			session.close() ;
//			return false ;
//		}
//		session.close() ;
//		return true ;
//	}
	
	public boolean createCSVFromDB(String filePath) {
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		try {
			Query query = session.createSQLQuery("SELECT * FROM employee INTO OUTFILE :filePath FIELDS ENCLOSED BY '\"' TERMINATED BY ';' ESCAPED BY '\"' LINES TERMINATED BY '\\r\\n'")
					.setParameter("filePath", filePath);
			query.setMaxResults(0);
			query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close() ;
			return true ;
		}
		session.close() ;
		return true ;

	}
	
	public boolean loadEmployeeFromCSV(String filePath) {
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		try {
			session.createSQLQuery("truncate employee").executeUpdate();
			Query query = session.createSQLQuery("LOAD DATA INFILE :filePath INTO TABLE employee FIELDS TERMINATED BY ';' ENCLOSED BY '\"'ESCAPED BY '\"' LINES TERMINATED BY '\\r\\n'")
					.setParameter("filePath", filePath);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close() ;
			return false ;
		}
		session.close() ;
		return true ;
	}

//	@Override
//	public boolean addEmployee(Employee employee) {
//		Session session = HibernateUtil.sf.openSession();
//		session.beginTransaction();
//		try {
//			session.save(employee);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			session.close() ;
//			return false ;
//		}
//		session.close() ;
//		return true ;
//	}
}
