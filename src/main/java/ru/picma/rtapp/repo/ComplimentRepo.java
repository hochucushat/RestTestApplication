package ru.picma.rtapp.repo;


import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public final class ComplimentRepo {

    private DsConfig ds;

    public ComplimentRepo(DsConfig ds) {
        this.ds = ds;
    }

    public List<String> getAll() {
        List<String> list = new ArrayList<>();
        try (Connection connection = ds.getConnection();){
            ResultSet result = connection.createStatement().executeQuery("SELECT message FROM compliment;");
            while(result.next()) {
                list.add(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
