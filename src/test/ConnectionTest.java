package test;

import org.springframework.beans.factory.annotation.Autowired;

import dao.BaseDao;

/**
 * 测试连接数据库
 * 
 * @author Administrator
 *
 */
public class ConnectionTest {
	@Autowired
	private static BaseDao BaseDaoImpl;

	public static void main(String[] args) {
		System.out.println("--------" + BaseDaoImpl);
	}

}
