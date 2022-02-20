package ru.picma.rtapp.repo;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class {@code DsConfig} is datasource configuration class for application.
 * HikariCP is used as connection pool.
 * Access to the database is done on the internal docker network.
 *
 * @author  pic
 * @since   0.0.1
 */
@Component
public final class DsConfig {

    private HikariDataSource ds;
    private String pwd = "root";
    private String username = "root";
    private String port = "5432";
    private String host = "rtapp_pg";

    /**
     * Constructs a DsConfig.
     */
    public DsConfig() {
        this.ds = new HikariDataSource();

        ds.setJdbcUrl("jdbc:postgresql://" + host + ":" + port + "/rtapp_db");
        ds.setUsername(username);
        ds.setPassword(pwd);
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    /**
     * @return connection from connection pool.
     */
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
