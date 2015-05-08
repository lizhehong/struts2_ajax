package cn.ITHong.strutsajax.dao;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ITHong.strutsajax.domain.Person;
import cn.ITHong.strutsajax.util.HibernateUtil;

public class PersonDao extends HibernateUtil{

	public List<Person> getAllPerson(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Person> pList = session.createQuery("from Person").list();
		transaction.commit();
		return pList;
	}
	public void createPerson(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		transaction.commit();
	}
	public void deletePerson(Long pid){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, pid);
		session.delete(person);
		transaction.commit();
	}
	public Person getPersonById(Long pid){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, pid);
		transaction.commit();
		return person;
	}
	public void updatePerson(Person person){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(person);
		transaction.commit();
	}
}
