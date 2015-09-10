/**
 * 
 */
package com.elitecore.monetization.db.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author brijesh.mistry
 *
 */
public class ResultsetWrapper {
	private static final String MODULE= "[ResultsetWrapper] ";
	
	private ResultSet resultSet;
	private Connection connection;
	private Statement statement;
	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	
	
	public void close(){		
		try{
			if(resultSet!=null){
				resultSet.close();
			}
		}catch(Exception e){
			System.out.println(MODULE+" Error in closing Result Set"+e);
			e.printStackTrace();
		}
		
		try{
			if(statement!=null){
				statement.close();
			}
		}catch(Exception e){
			System.out.println(MODULE+"Error in closing statement "+e);
			e.printStackTrace();
		}
		
		try{
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(Exception e){
			System.out.println(MODULE+"Error in closing database connection "+e);
			e.printStackTrace();
		}
	}

	/**
	 * @param resultSet
	 * @param connection
	 * @param statement
	 */
	public ResultsetWrapper(ResultSet resultSet, Connection connection,
			Statement statement) {
		super();
		this.resultSet = resultSet;
		this.connection = connection;
		this.statement = statement;
	}
	
}
