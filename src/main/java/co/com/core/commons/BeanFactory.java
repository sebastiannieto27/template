package co.com.core.commons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.core.domain.User;

public class BeanFactory {

	ApplicationContext context = new ClassPathXmlApplicationContext("application-bean-context.xml");
	
	 private Session session;
	 private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		sessionFactory = (SessionFactory) context.getBean("hibernate4AnnotatedSessionFactory");
		return sessionFactory;
	}
	
	public String getUserName() {
		User user = null;
		try {
			getSessionFactory();
			session = this.sessionFactory.openSession();
			user = (User) session.get(User.class, new Integer(1));
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
		return user.getCompleteName();
	}
}
