package proto.orm.board.contact.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proto.orm.board.contact.domain.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addContact(Contact contact) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		session.save(contact);
    		session.getTransaction();
    		tx.commit();
    		System.out.println("Insert Completed");
    	} catch(HibernateException e) {
    		if(tx!=null) tx.rollback(); 
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    }

    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {
    	System.out.println("SessionFactory is " + this.sessionFactory);
    	return this.sessionFactory.getCurrentSession().createQuery("FROM Contact").list();
    }

    public void removeContact(int id) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try {
    		tx = session.beginTransaction();
    		Contact contact = (Contact) session.load(Contact.class, id);
    		session.delete(contact);
    		session.getTransaction();
    		tx.commit();
    		System.out.println("Deletion Completed");
    	} catch (HibernateException e ) {
    		if(tx!=null)tx.rollback();
    		e.printStackTrace();
    	} finally{
    		session.close();
    	}
    }
}
