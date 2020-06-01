package com.ysu.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class DbUtil implements DataSource{
	private String dbUrl = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8";
	private String dbUser = "root";
	private String dbPassword = "root";
	private String dbDriver="com.mysql.jdbc.Driver";
	
	private static DbUtil dbUtil = new DbUtil();
	
	public static DbUtil getInstance() {
		// TODO Auto-generated method stub
		return dbUtil;
	}
	private DbUtil() {
		
	}
	
	public static int POOL_MAX =5;//���������
	public Connection connection = null;//��ʾ��ǰ��connection
	
	private LinkedList<Connection> pool = new LinkedList<Connection>();//���ݿ����ӳ�
	
	public Connection getConnection() {
		
		try {
			if(pool.size() == 0) {
				Class.forName(dbDriver);//ָ��jar��������ʱ����
				
				for(int i = 0;i<POOL_MAX;i++) {
					pool.add(DriverManager.getConnection(dbUrl,dbUser,dbPassword));
				}
				System.out.println("��ʼ�����ӳأ��ɹ�����" + POOL_MAX + "�����ݿ����ӷŵ����ӳ��У�");
			}
			connection = pool.remove();//�����ӳ���ȡ��һ��������
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	/*
	 * �ͷ����ݿ����ӵ����ӳ���
	 */
	public void releaseConnection() {
		//�Żص����ӳ���
		pool.add(connection);
		System.out.println("�ɹ��黹���ӵ����ӳأ���ǰ���ӳ���" + pool.size() + "���������ӣ�");
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		dbUtil.getConnection();
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
