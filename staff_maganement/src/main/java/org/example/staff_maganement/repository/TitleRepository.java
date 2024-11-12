package org.example.staff_maganement.repository;

import org.example.staff_maganement.model.Title;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitleRepository extends BaseRepository implements IRepository<Title> {

    @Override
    public List<Title> findAll() {
        List<Title> titles = new ArrayList<>();
        String query = "SELECT * FROM title";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_title");
                String name = resultSet.getString("name_title");
                titles.add(new Title(id, name));
                System.out.println("So luong phan tu trong danh sach title: " + titles.size());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return titles;
    }

    @Override
    public Title findById(int id) {
        Title title = null;
        String query = "SELECT * FROM title WHERE id_title = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name_title");
                title = new Title(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return title;
    }

    @Override
    public boolean save(Title title) {
        String query = "INSERT INTO title (name_title) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title.getNameTitle());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Title title) {
        String query = "UPDATE title SET name_title = ? WHERE id_title = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title.getNameTitle());
            statement.setInt(2, title.getIdTitle());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM title WHERE id_title = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
