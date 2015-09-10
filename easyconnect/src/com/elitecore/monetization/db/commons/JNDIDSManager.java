package com.elitecore.monetization.db.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.dialect.Dialect;
import org.hibernate.service.jdbc.dialect.internal.StandardDialectResolver;
import org.hibernate.service.jdbc.dialect.spi.DialectResolver;


public class JNDIDSManager {

	private static final String MODULE = "[JNDIDSManager]";
	private static Map<String, DataSource> jndiDataSourceMap = new HashMap<String, DataSource>();
	private static DataSource dataSource;
	private static Map<String, Dialect> jndiDialectMap = new HashMap<String, Dialect>();
	private static DialectResolver dialectResolver = new StandardDialectResolver();	
	
	public final static String JNDI_CONTEXT_PATH = "java:/comp/env/";
	
	public static void initJNDIDataSource() {
		try {
			System.out.println(MODULE + " In Init JNDI DataSource Method");
			InitialContext ctx = new InitialContext();
			StringBuffer jndiContextPath = new StringBuffer(20);
			jndiContextPath.append(JNDI_CONTEXT_PATH).append("jdbc/");
			NamingEnumeration<NameClassPair> list = ctx.list(jndiContextPath
					.toString());
			while (list.hasMore()) {
				NameClassPair nameClassPair = list.next();
				String jndiResourceName = nameClassPair.getName();
				StringBuffer jndiResourceURL = new StringBuffer(jndiContextPath)
						.append(jndiResourceName);
				DataSource ds = (DataSource) ctx.lookup(jndiResourceURL
						.toString());
				dataSource = ds;
				jndiDataSourceMap.put(jndiResourceName, ds);
				
				Connection connection = null;
				try{
					connection = ds.getConnection();
					Dialect dialect = dialectResolver.resolveDialect(connection.getMetaData());
					System.out.println(MODULE + " Resolve Dialect : " + dialect.getClass().getName() + " for JNDI Resource : "  + jndiResourceName);
					jndiDialectMap.put(jndiResourceName, dialect);
				}catch(Exception e){						
					System.out.println(MODULE + " Exception occured in get connection: ");
					e.printStackTrace();
					System.out.println(MODULE + " Fail to create connection object. Please check connection url, userName & password. Reason : "+ e.getMessage());
				}
				finally {
					if(connection != null){
						connection.close();
					}
				}

			}
		} catch (NamingException e) {			
			System.out.println(MODULE + " Error while initialize JNDI DataSource:" );
			e.printStackTrace();
			System.out.println(MODULE + " Monetization Database Down. Please check, please check database configuration. Reason :"+ e.getMessage());
		} catch (Exception e) {
			System.out.println(MODULE + " Error while initialize JNDI DataSource:" );
			e.printStackTrace();
		}
	}

	public static DataSource getJDBCDataSource(final String name) {
		return jndiDataSourceMap.get(name);
	}

	public static Set<String> getJndiDataSourceKeySet() {
		return jndiDataSourceMap.keySet();
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			System.out.println(MODULE + "Error in getting connections" );
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param query -  Database query for excution
	 * @param queryTimeOut - queryTimeOut Max time that required to excute this query .
	 * @return ResultsetWrapper object which contains resultset, connection and statement
	 * @throws java.sql.SQLException
	 * @throws java.lang.NullPointerException
	 */
	public static ResultsetWrapper getInstanceResultSetWrapper(String query, int queryTimeOut) throws java.sql.SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = getConnection();
			if (conn == null) {
				System.out.println(MODULE + " Connection is null.");
				return null;
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.println(MODULE + " Exception occured in getInstanceResultSetWrapper method ");
			e.printStackTrace();
		}
		return new ResultsetWrapper(rs, conn, stmt);
	}
	
	/**
	 * 
	 * @param rsw - ResultsetWrapper object has resultset
	 */
	public static void close(ResultsetWrapper rsw){
		System.out.println(MODULE+"Enter into close with result set wrapper methods ");
		
		if(rsw == null){
			System.out.println(MODULE+" Here resultSet Wrapper is null ,But it should not be null.");
			return;
		}
		
		try{
			if(rsw.getResultSet()!=null){
				rsw.getResultSet().close();
			}
		}catch(Exception e){
			System.out.println(MODULE+" Error in closing Result Set"+e);
			e.printStackTrace();
		}
		
		try{
			if(rsw.getStatement()!=null){
				rsw.getStatement().close();
			}
		}catch(Exception e){
			System.out.println(MODULE+" Error in closing statement "+e);
			e.printStackTrace();
		}
		
		try{
			if(rsw.getConnection()!=null && !rsw.getConnection().isClosed()){
				rsw.getConnection().close();
			}
		}catch(Exception e){
			System.out.println(MODULE+" Error in closing database connection "+e);
			e.printStackTrace();
		}
		System.out.println(MODULE+" All database connection object closed successfully ");
	}
	
	
	/**
	 * <p> This Methods is used for DDL DML defination change operation .It will return no of database object affected. 
	 * @param Database query for excution
	 * @param queryTimeOut Max time that required to excute this query . 
	 * @return Status after database query excutions.
	 * 
	 */
	public static int executeUpdate(String query, int queryTimeOut) throws SQLIntegrityConstraintViolationException{
		System.out.println(MODULE + "Enter into excute update with query :"+query);
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try{
			conn= getConnection();
			stmt = conn.createStatement();
			//stmt.setQueryTimeout(queryTimeOut);
			result = stmt.executeUpdate(query);
			
			System.out.println(MODULE + " Result of excution of query :"+result);
			
		}catch(SQLIntegrityConstraintViolationException  e){
			System.out.println(MODULE+" Exception in excuteUpdate Methods"+e);
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			System.out.println(MODULE+" Exception in excuteUpdate Methods"+e);
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(Exception e){
				System.out.println(MODULE+" Exception in closing statement object "+e);
				e.printStackTrace();
			}
			try{
				conn.close();
			}catch(Exception e){
				System.out.println(MODULE+" Exception in Closing database connection objects "+e);
				e.printStackTrace();
			}
		}						
		return result;

	}
	public static Dialect getDialect(final String name) {
		return jndiDialectMap.get(name);
	}
}