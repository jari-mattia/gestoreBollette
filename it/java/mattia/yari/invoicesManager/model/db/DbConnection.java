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
			config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/invoicesmanager");
			config.setUsername(cp.getProperty("user"));
			config.setPassword(cp.getProperty("password"));
			config.addDataSourceProperty("cachePrepStmts", cp.getProperty("cachePrepStmts"));
			config.addDataSourceProperty("prepStmtCacheSize", cp.getProperty("prepStmtCacheSize"));
			config.addDataSourceProperty("prepStmtCacheSqlLimit", cp.getProperty("prepStmtCacheSqlLimit"));
			config.addDataSourceProperty("useServerPrepStmts", cp.getProperty("useServerPrepStmts"));
			config.addDataSourceProperty("useLocalSessionState", cp.getProperty("useLocalSessionState"));
			config.addDataSourceProperty("rewriteBatchedStatements", cp.getProperty("rewriteBatchedStatements"));
			config.addDataSourceProperty("cacheResultSetMetadata", cp.getProperty("cacheResultSetMetadata"));
			config.addDataSourceProperty("cacheServerConfiguration", cp.getProperty("cacheServerConfiguration"));
			config.addDataSourceProperty("elideSetAutoCommits", cp.getProperty("elideSetAutoCommits"));
			config.addDataSourceProperty("maintainTimeStats", cp.getProperty("maintainTimeStats"));

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
	
	
