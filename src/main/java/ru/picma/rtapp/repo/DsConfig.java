package ru.picma.rtapp.repo;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public final class DsConfig {

    private HikariDataSource ds;

    public DsConfig() {
        this.ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://rtapp_pg:5432/rtapp_db");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
