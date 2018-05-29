package it.java.mattia.yari.invoicesManager.model.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbConnection {

	private static HikariDataSource ds ;
	
	
	public static Connection getConnection(){
		
		if(ds == null) {
			ConfigurationProperties cp = new ConfigurationProperties();
			HikariConfig config = new HikariConfig();
			
			/* driver configuration  */
			config.setJdbcUrl(cp.getJdbcUrl());
			config.setUsername(cp.getUser());
			config.setPassword(cp.getPassword());
			config.addDataSourceProperty("cachePrepStmts", cp.getCachePrepStmts());
			config.addDataSourceProperty("prepStmtCacheSize", cp.getPrepStmtCacheSize());
			config.addDataSourceProperty("prepStmtCacheSqlLimit", cp.getPrepStmtCacheSqlLimit());
			config.addDataSourceProperty("useServerPrepStmts", cp.getUseServerPrepStmts());
			config.addDataSourceProperty("useLocalSessionState", cp.getUseLocalSessionState());
			config.addDataSourceProperty("rewriteBatchedStatements", cp.getRewriteBatchedStatements());
			config.addDataSourceProperty("cacheResultSetMetadata", cp.getCacheResultSetMetadata());
			config.addDataSourceProperty("cacheServerConfiguration", cp.getCacheServerConfiguration());
			config.addDataSourceProperty("elideSetAutoCommits", cp.getElideSetAutoCommits());
			config.addDataSourceProperty("maintainTimeStats", cp.getMaintainTimeStats());

			ds = new HikariDataSource(config);

		}
		try {
			return ds.getConnection();
		
		}
		catch(SQLException e) {
			    System.err.println("Errore di connessione al db");
			    throw new RuntimeException(e);
			}
	}
	

}
	
	
