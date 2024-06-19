package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDao {

	private Connection conn;

	public SearchDao(Connection conn) {
		this.conn = conn;
	}

	public String searchBuyerId(String name, String phone) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select id from member where name = ? and phone = ? and code like 'Cu%'");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return (rs.getString("id"));
			} else {
				return null;
			}

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}

	}
	
	public String searchSellerId(String name, String phone) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select id from member where name = ? and phone = ? and code like 'Se%'");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return (rs.getString("id"));
			} else {
				return null;
			}

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
		}

	}

}
