package ru.picma.rtapp.repo;


import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class {@code ComplimentRepo} sends database queries.
 *
 * @author  pic
 * @see     ru.picma.rtapp.repo.DsConfig
 * @since   0.0.1
 */
@Repository
public final class ComplimentRepo {

    private DsConfig ds;

    /**
     * Constructs a ComplimentRepo.
     */
    public ComplimentRepo(DsConfig ds) {
        this.ds = ds;
    }

    /**
     * This method return all compliments of Database.
     *
     * @return {@code List<String>} or null.
     */
    public Map<Integer, String> getAll() {
        Map<Integer, String> map = null;
        try (Connection connection = ds.getConnection()){
            map = new HashMap<>();
            ResultSet result = connection.createStatement().executeQuery("SELECT id, message FROM compliment;");
            while(result.next()) {
                map.put(result.getInt(1), result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * This method takes <b>{@code String compliment}</b> and add this in the Database.
     *
     * @return the number of changes in the database.
     * If the field was added it will return 1, if not, it will return 0.
     */
    public int add(String compliment) {
        int added = 0;
        try (Connection connection = ds.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO compliment(message) VALUES (?);");
            statement.setString(1, compliment);
            added = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }

    /**
     * This method takes <b>{@code int id}</b> and remove field in the Database.
     *
     * @return the number of changes in the database.
     * If the field was removed it will return 1, if not, it will return 0.
     */
    public int remove(int id) {
        int removed = 0;
        try (Connection connection = ds.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM compliment WHERE id = ?;");
            statement.setInt(1, id);
            removed = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return removed;
    }

}
