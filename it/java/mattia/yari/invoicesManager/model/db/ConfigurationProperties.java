package it.java.mattia.yari.invoicesManager.model.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties extends Properties{

	/**
	 * a read-only class wrapper for config.properties file 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String dataSourceClassName;
	private String jdbcUrl;
	private String user;
	private String password;
	private String databaseName;
	private String portNumber;
	private String serverName;
	private String cachePrepStmts;
	private String prepStmtCacheSize;
	private String prepStmtCacheSqlLimit;
	private String useServerPrepStmts;
	private String useLocalSessionState;
	private String rewriteBatchedStatements;
	private String cacheResultSetMetadata;
	private String cacheServerConfiguration;
	private String elideSetAutoCommits;
	private String maintainTimeStats;
	
	
	
	
	public ConfigurationProperties() {
		super();
		FileInputStream is;
		try {
			is = new FileInputStream("../gestoreBollette/lib/config.properties");
			this.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("Configuration file not found in /lib folder");
			e.getMessage();
		} catch (IOException e) {
			System.out.println("error to load config file");
			e.getMessage();
		}
		/*
		this.dataSourceClassName = this.getProperty(dataSourceClassName);
		this.jdbcUrl = this.getProperty(jdbcUrl);
		this.user = this.getProperty(user);
		this.password = this.getProperty(password);
		this.databaseName = this.getProperty(databaseName);
		this.portNumber = this.getProperty(portNumber);
		this.serverName = this.getProperty(serverName);
		this.cachePrepStmts = this.getProperty(cachePrepStmts);
		this.prepStmtCacheSize = this.getProperty(prepStmtCacheSize);
		this.prepStmtCacheSqlLimit = this.getProperty(prepStmtCacheSqlLimit);
		this.useServerPrepStmts = this.getProperty(useServerPrepStmts);
		this.useLocalSessionState = this.getProperty(useLocalSessionState);
		this.rewriteBatchedStatements =  this.getProperty(rewriteBatchedStatements);
		this.cacheResultSetMetadata = this.getProperty(cacheResultSetMetadata);
		this.cacheServerConfiguration = this.getProperty(cacheServerConfiguration);
		this.elideSetAutoCommits = this.getProperty(elideSetAutoCommits);
		this.maintainTimeStats = this.getProperty(maintainTimeStats);*/
	}


	




	public String getDataSourceClassName() {
		return dataSourceClassName;
	}







	public String getJdbcUrl() {
		return jdbcUrl;
	}







	public String getUser() {
		return user;
	}







	public String getPassword() {
		return password;
	}







	public String getDatabaseName() {
		return databaseName;
	}







	public String getPortNumber() {
		return portNumber;
	}







	public String getServerName() {
		return serverName;
	}







	public String getCachePrepStmts() {
		return cachePrepStmts;
	}







	public String getPrepStmtCacheSize() {
		return prepStmtCacheSize;
	}







	public String getPrepStmtCacheSqlLimit() {
		return prepStmtCacheSqlLimit;
	}







	public String getUseServerPrepStmts() {
		return useServerPrepStmts;
	}







	public String getUseLocalSessionState() {
		return useLocalSessionState;
	}







	public String getRewriteBatchedStatements() {
		return rewriteBatchedStatements;
	}







	public String getCacheResultSetMetadata() {
		return cacheResultSetMetadata;
	}







	public String getCacheServerConfiguration() {
		return cacheServerConfiguration;
	}







	public String getElideSetAutoCommits() {
		return elideSetAutoCommits;
	}







	public String getMaintainTimeStats() {
		return maintainTimeStats;
	}







	public static void main(String[] args) {
		

	}

}
