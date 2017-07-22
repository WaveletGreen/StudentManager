package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sun.mail.util.QEncoderStream;

import entity.Studentsystem;
import util.HibernateSessionFactory;

/**
 * 测试连接数据库
 * 
 * @author Administrator
 *
 */
public class ConnectionTest {

	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Studentsystem");
		List<Studentsystem> students = query.list();
		for (Studentsystem studentsystem : students) {
			System.out.println(studentsystem.getName());
		}
	}

}
