package cn.edu.nwsuaf.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public final class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	//使用线程局部模式
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	//私有的构造方法，保证不被实例化
	private HibernateUtil(){
		
	}
	//初始化sessionFactory
	static{
		try {
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
	}
	
	//获取全新的session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//获取和线程关联的session
	public static Session getCurrentSession(){
		Session session = threadLocal.get();
		if(session == null || !session.isOpen()){
			session = getSession();
			threadLocal.set(session);
		}
		return session;
	}
	
	 
	 
}
