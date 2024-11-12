package org.example.staff_maganement.repository;

import org.example.staff_maganement.model.Part;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartRepository extends BaseRepository implements IRepository<Part> {

    @Override
    public List<Part> findAll() {
        List<Part> parts = new ArrayList<>();
        String query = "SELECT * FROM part";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_part");
                String name = resultSet.getString("name_part");
                parts.add(new Part(id, name));
            }
            System.out.println("So luong phan tu trong danh sach part: " + parts.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parts;
    }

    @Override
    public Part findById(int id) {
        Part part = null;
        String query = "SELECT * FROM part WHERE id_part = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name_part");
                part = new Part(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return part;
    }

    @Override
    public boolean save(Part part) {
        String query = "INSERT INTO part (name_part) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, part.getNamePart());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Part part) {
        String query = "UPDATE part SET name_part = ? WHERE id_part = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, part.getNamePart());
            statement.setInt(2, part.getIdPart());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM part WHERE id_part = ?";

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
