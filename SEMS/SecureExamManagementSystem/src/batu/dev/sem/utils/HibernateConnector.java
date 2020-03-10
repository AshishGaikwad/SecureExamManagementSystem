package batu.dev.sem.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

	private static HibernateConnector lHibernateConnector;

	private HibernateConnector() {
	}

	public static HibernateConnector getInstance() {
		if (lHibernateConnector == null) {
			synchronized (HibernateConnector.class) {
				lHibernateConnector = new HibernateConnector();
			}
		}
		return lHibernateConnector;
	}

	public static Session getSession(SessionFactory lSessionFactory) {
		return getFactory(lSessionFactory).getCurrentSession();
	}

	public static SessionFactory getFactory(SessionFactory lSessionFactory) {
		return lSessionFactory;
	}

	public static void main(String[] args) {

		Test lTest = new Test();
		lTest.setlName("Rutik2");
		lTest.setlLastMame("Gaikwad2");

		Session lSession = getSession(new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Test.class)
				.buildSessionFactory());

		lSession.beginTransaction();
		lSession.save(lTest);
		lSession.getTransaction().commit();

	}
}
