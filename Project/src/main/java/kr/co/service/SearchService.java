package kr.co.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.dao.SearchDao;

@Service
public class SearchService {

	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	private static SearchService instance = new SearchService();

	public static SearchService getInstance() {
		return instance;
	}

	private SearchService() {
	}

	public String searchBuyerId(String name, String phone) throws Exception {
		Connection conn = null;
		Class.forName(db_classname);
		try {
			String jdbcDriver = db_url;
			String dbUser = db_username;
			String dbPass = db_password;

			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// DAO 객체를 생성 시 Connection 전달
			SearchDao searchDao = new SearchDao(conn);
			String userid = searchDao.searchBuyerId(name, phone);
			System.out.println(name);

			return userid;

		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	public String searchSellerId(String name, String phone) throws Exception {
		Connection conn = null;
		Class.forName(db_classname);
		try {
			String jdbcDriver = db_url;
			String dbUser = db_username;
			String dbPass = db_password;

			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// DAO 객체를 생성 시 Connection 전달
			SearchDao searchDao = new SearchDao(conn);
			String userid = searchDao.searchSellerId(name, phone);
			System.out.println(name);

			return userid;

		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

}
