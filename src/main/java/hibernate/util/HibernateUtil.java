package hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import hibernate.model.Pessoa;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSession() {
		if(sessionFactory == null) {
			
			try {
				Configuration configuration = new Configuration();
				
				Properties properties = new Properties();
				
				// URL do banco de dados
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/java");
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "1234");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				
				
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(Pessoa.class);
				
				ServiceRegistry registry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(registry);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return sessionFactory;
	}
}
