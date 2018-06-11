package com.google.kleinikov.stanislav.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

@Component
public class ConnectionPool {

	@Autowired
	private MysqlConnectionPoolDataSource MysqlConnectionPoolDataSource;

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = MysqlConnectionPoolDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
